package hr.fer.inf.sus.gstarbe.service.impl;

import hr.fer.inf.sus.gstarbe.mapper.TournamentMapper;
import hr.fer.inf.sus.gstarbe.model.dbo.Tournament;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentResponseDto;
import hr.fer.inf.sus.gstarbe.repository.TournamentRepository;
import hr.fer.inf.sus.gstarbe.service.TournamentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {

    final TournamentRepository tournamentRepository;
    final TournamentMapper tournamentMapper;

    @Override
    public List<TournamentResponseDto> getAllTournaments() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return tournaments.stream().map(tournamentMapper::toDto).toList();
    }

    @Override
    public TournamentResponseDto getTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("Tournament with given id not found."));
        return tournamentMapper.toDto(tournament);
    }

    @Override
    public TournamentResponseDto createTournament(TournamentRequestDto tournamentRequestDto) {
        //todo izvuci point system iz requesta i njih spremiti
        Tournament tournament = tournamentRepository.save(tournamentMapper.toEntity(tournamentRequestDto));
        return getTournament(tournament.getTId());
    }

    @Override
    public TournamentResponseDto updateTournament(Long tournamentId, TournamentRequestDto tournamentRequestDto) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("Tournament with given id not found."));

        tournamentMapper.toEntity(tournament, tournamentRequestDto);
        tournamentRepository.save(tournament);
        return getTournament(tournamentId);
    }

    @Override
    public void deleteTournament(Long tournamentId) {
        if (!tournamentRepository.existsById(tournamentId)) {
            throw new EntityNotFoundException("Tournament with given id not found.");
        }

        tournamentRepository.deleteById(tournamentId);
    }
}
