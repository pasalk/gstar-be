package hr.fer.inf.sus.gstarbe.controller;

import hr.fer.inf.sus.gstarbe.model.dto.TeamRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TeamResponseDto;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentResponseDto;
import hr.fer.inf.sus.gstarbe.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {
    final TeamService teamService;

    @PostMapping("/tournament/{id}/team")
    public ResponseEntity<TeamResponseDto> createTeam(@PathVariable Long id, @RequestBody final TeamRequestDto teamRequestDto) {
        return ResponseEntity.ok(teamService.createTeam(id, teamRequestDto));
    }

    @PostMapping("/team")
    public ResponseEntity<TeamResponseDto> createTeam(@RequestBody final TeamRequestDto teamRequestDto) {
        return ResponseEntity.ok(teamService.createTeam(teamRequestDto));
    }

    @PostMapping("/team/{id}")
    public ResponseEntity<TeamResponseDto> updateTeam(@PathVariable Long id, @RequestBody final TeamRequestDto teamRequestDto) {
        return ResponseEntity.ok(teamService.updateTeam(id, teamRequestDto));
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Team with id: " + id + " was successfully deleted.");
    }
}
