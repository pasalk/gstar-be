package hr.fer.inf.sus.gstarbe.service;

import hr.fer.inf.sus.gstarbe.model.dto.TournamentRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentResponseDto;

import java.util.List;

public interface TournamentService {
    List<TournamentResponseDto> getAllTournaments();

    TournamentResponseDto getTournament(Long tournamentId);

    TournamentResponseDto createTournament(TournamentRequestDto tournamentRequestDto);

    TournamentResponseDto updateTournament(Long tournamentId, TournamentRequestDto tournamentRequestDto);

    void deleteTournament(Long tournamentId);
}
