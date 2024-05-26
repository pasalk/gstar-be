package hr.fer.inf.sus.gstarbe.controller;

import hr.fer.inf.sus.gstarbe.model.dto.KeyValueDto;
import hr.fer.inf.sus.gstarbe.service.CodebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CodebookController {
    final CodebookService codebookService;

    @GetMapping("/result-types")
    public ResponseEntity<List<KeyValueDto>> getAllResultTypes() {
        return ResponseEntity.ok(codebookService.getAllResultTypes());
    }

    @GetMapping("/statistics-types")
    public ResponseEntity<List<KeyValueDto>> getAllStatisticsTypes() {
        return ResponseEntity.ok(codebookService.getAllStatisticsTypes());
    }

    @GetMapping("/tournament-formats")
    public ResponseEntity<List<KeyValueDto>> getAllTournamentFormats() {
        return ResponseEntity.ok(codebookService.getAllTournamentFormats());
    }

    @GetMapping("/tournament-statuses")
    public ResponseEntity<List<KeyValueDto>> getAllTournamentStatuses() {
        return ResponseEntity.ok(codebookService.getAllTournamentStatuses());
    }

    @GetMapping("/user-types")
    public ResponseEntity<List<KeyValueDto>> getAllUserTypes() {
        return ResponseEntity.ok(codebookService.getAllUserTypes());
    }
}