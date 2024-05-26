package hr.fer.inf.sus.gstarbe.service.impl;

import hr.fer.inf.sus.gstarbe.mapper.*;
import hr.fer.inf.sus.gstarbe.model.dbo.*;
import hr.fer.inf.sus.gstarbe.model.dto.*;
import hr.fer.inf.sus.gstarbe.repository.*;
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
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final TournamentTeamMapper tournamentTeamMapper;
    private final TournamentTeamRepository tournamentTeamRepository;

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

        List<Team> teams = tournament.getTournamentTeams().stream().map(TournamentTeam::getTeam).toList();
        List<TeamResponseDto> teamResponseDtoList = new ArrayList<>();
        for (Team team : teams) {
            teamResponseDtoList.add(teamMapper.toDto(team));
        }

        tournamentResponseDto.setTeams(teamResponseDtoList);

        return tournamentResponseDto;
    }

    @Override
    public TournamentResponseDto createTournament(TournamentRequestDto tournamentRequestDto) {
        Tournament tournament = tournamentMapper.toEntity(tournamentRequestDto);
        tournament = tournamentRepository.save(tournament);

        List<Team> teams = new ArrayList<>();
        for (TeamRequestDto teamRequestDto : tournamentRequestDto.getTeams()) {
            teams.add(teamRepository.save(teamMapper.toEntity(teamRequestDto)));
        }

        for (Team team : teams) {
            TournamentTeam tournamentTeam = tournamentTeamMapper.toEntity(tournament.getTId(), team.getTId());
            tournamentTeamRepository.save(tournamentTeam);
        }

        return getTournament(tournament.getTId());
    }

    @Override
    public TournamentResponseDto updateTournament(Long tournamentId, TournamentRequestDto tournamentRequestDto) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("Tournament with given id not found."));

        tournamentMapper.toEntity(tournament, tournamentRequestDto);
        tournamentRepository.save(tournament);

        List<Long> currentTeams = tournament.getTournamentTeams().stream().map(TournamentTeam::getTtId).toList();
        List<Long> savedTeams = new ArrayList<>();

        for (TeamRequestDto teamRequestDto : tournamentRequestDto.getTeams()) {
            Optional<TournamentTeam> tournamentTeam = tournamentTeamRepository.findByTournamentIdAndTeamName(tournamentId, teamRequestDto.getName());
            if (tournamentTeam.isPresent()) {
                Team team = tournamentTeam.get().getTeam();
                teamMapper.toEntity(team, teamRequestDto);
                teamRepository.save(team);
            } else {
                Team team = teamRepository.save(teamMapper.toEntity(teamRequestDto));
                tournamentTeam = Optional.of(tournamentTeamRepository.save(tournamentTeamMapper.toEntity(tournamentId, team.getTId())));
            }
            savedTeams.add(tournamentTeam.get().getTtId());
        }

        currentTeams = currentTeams.stream().filter(ttId -> !savedTeams.contains(ttId)).toList();
        if (!currentTeams.isEmpty()) {
            tournamentTeamRepository.deleteAllById(currentTeams);
        }

        return getTournament(tournamentId);
    }

    @Override
    public void deleteTournament(Long tournamentId) {
        if (!tournamentRepository.existsById(tournamentId)) {
            throw new EntityNotFoundException("Tournament with given id not found.");
        }

        List<TournamentTeam> tournamentTeams = tournamentTeamRepository.findAllByTournamentId(tournamentId);
        tournamentTeamRepository.deleteAll(tournamentTeams);

        tournamentRepository.deleteById(tournamentId);
    }
}
