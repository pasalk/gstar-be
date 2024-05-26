package hr.fer.inf.sus.gstarbe.controller;

import hr.fer.inf.sus.gstarbe.model.dto.TournamentRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentResponseDto;
import hr.fer.inf.sus.gstarbe.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TournamentController {
    final TournamentService tournamentService;

    @GetMapping("/tournaments")
    public ResponseEntity<List<TournamentResponseDto>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @GetMapping("/tournament/{id}")
    public ResponseEntity<TournamentResponseDto> getTournament(@PathVariable Long id) {
        return ResponseEntity.ok(tournamentService.getTournament(id));
    }

    @PostMapping("/tournament")
    public ResponseEntity<TournamentResponseDto> createTournament(@RequestBody final TournamentRequestDto tournamentRequestDto) {
        return ResponseEntity.ok(tournamentService.createTournament(tournamentRequestDto));
    }

    @PostMapping("/tournament/{id}")
    public ResponseEntity<TournamentResponseDto> updateTournament(@PathVariable Long id, @RequestBody final TournamentRequestDto tournamentRequestDto) {
        return ResponseEntity.ok(tournamentService.updateTournament(id, tournamentRequestDto));
    }

    @DeleteMapping("/tournament/{id}")
    public ResponseEntity<String> deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.ok("Tournament with id: " + id + " was successfully deleted.");
    }
}
