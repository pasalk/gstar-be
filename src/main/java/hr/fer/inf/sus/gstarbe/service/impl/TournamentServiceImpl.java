package hr.fer.inf.sus.gstarbe.service.impl;

import hr.fer.inf.sus.gstarbe.mapper.PointSystemMapper;
import hr.fer.inf.sus.gstarbe.mapper.TournamentMapper;
import hr.fer.inf.sus.gstarbe.model.dbo.PointSystem;
import hr.fer.inf.sus.gstarbe.model.dbo.Tournament;
import hr.fer.inf.sus.gstarbe.model.dbo.TournamentStructure;
import hr.fer.inf.sus.gstarbe.model.dto.*;
import hr.fer.inf.sus.gstarbe.repository.PointSystemRepository;
import hr.fer.inf.sus.gstarbe.repository.TournamentRepository;
import hr.fer.inf.sus.gstarbe.repository.TournamentStructureRepository;
import hr.fer.inf.sus.gstarbe.service.TournamentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TournamentServiceImpl implements TournamentService {

    final TournamentRepository tournamentRepository;
    final TournamentMapper tournamentMapper;
    final TournamentStructureRepository tournamentStructureRepository;
    final PointSystemMapper pointSystemMapper;
    private final PointSystemRepository pointSystemRepository;

    @Override
    public List<TournamentResponseDto> getAllTournaments() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return tournaments.stream().map(tournamentMapper::toDto).toList();
    }

    @Override
    public TournamentResponseDto getTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("Tournament with given id not found."));
        TournamentResponseDto tournamentResponseDto = tournamentMapper.toDto(tournament);

        List<PointSystemResponseDto> pointSystemResponseDtoList = tournament.getTournamentStructure().getPointSystems()
                .stream()
                .map(pointSystemMapper::toDto).toList();

        TournamentStructureResponseDto tournamentStructureResponseDto = tournamentResponseDto.getTournamentStructureResponseDto();
        tournamentStructureResponseDto.setPointSystemResponseDtoList(pointSystemResponseDtoList);

        return tournamentResponseDto;
    }

    @Override
    public TournamentResponseDto createTournament(TournamentRequestDto tournamentRequestDto) {
        //todo validate point system
        Tournament tournament = tournamentMapper.toEntity(tournamentRequestDto);

        TournamentStructure tournamentStructure = tournamentStructureRepository.save(tournament.getTournamentStructure());
        tournament.setTournamentStructure(tournamentStructure);

        tournament = tournamentRepository.save(tournament);

        pointSystemRepository.saveAll(
                tournamentRequestDto.getTournamentStructureRequestDto().getPointSystemRequestDtoList()
                        .stream()
                        .map(pointSystemRequestDto -> pointSystemMapper.toEntity(pointSystemRequestDto, tournamentStructure.getTsId()))
                        .toList());

        return getTournament(tournament.getTId());
    }

    @Override
    public TournamentResponseDto updateTournament(Long tournamentId, TournamentRequestDto tournamentRequestDto) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("Tournament with given id not found."));

        tournamentMapper.toEntity(tournament, tournamentRequestDto);

        TournamentStructure tournamentStructure = tournamentStructureRepository.save(tournament.getTournamentStructure());
        tournament.setTournamentStructure(tournamentStructure);

        tournamentRepository.save(tournament);

        List<Long> currentPointSystemIds = tournamentStructure.getPointSystems().stream().map(PointSystem::getPsId).toList();
        List<Long> savedPointSystems = new ArrayList<>();

        for (PointSystemRequestDto pointSystemRequestDto : tournamentRequestDto.getTournamentStructureRequestDto().getPointSystemRequestDtoList()) {
            Optional<PointSystem> pointSystem = pointSystemRepository.findByTournamentStructureIdAndResultTypeId(tournamentStructure.getTsId(), pointSystemRequestDto.getResultTypeId());
            if (pointSystem.isPresent()) {
                pointSystemMapper.toEntity(pointSystem.get(), pointSystemRequestDto);
            } else {
                pointSystem = Optional.of(pointSystemMapper.toEntity(pointSystemRequestDto, tournamentStructure.getTsId()));
            }
            PointSystem savedPointSystem = pointSystemRepository.save(pointSystem.get());
            savedPointSystems.add(savedPointSystem.getPsId());
        }

        currentPointSystemIds = currentPointSystemIds.stream().filter(psId -> !savedPointSystems.contains(psId)).toList();
        if (!currentPointSystemIds.isEmpty()) {
            pointSystemRepository.deleteAllById(currentPointSystemIds);
        }

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
