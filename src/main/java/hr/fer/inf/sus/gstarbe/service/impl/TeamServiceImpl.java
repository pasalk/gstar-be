package hr.fer.inf.sus.gstarbe.service.impl;

import hr.fer.inf.sus.gstarbe.mapper.TeamMapper;
import hr.fer.inf.sus.gstarbe.mapper.TeamsPlayersMapper;
import hr.fer.inf.sus.gstarbe.mapper.TournamentTeamMapper;
import hr.fer.inf.sus.gstarbe.mapper.TournamentTeamMapperImpl;
import hr.fer.inf.sus.gstarbe.model.dbo.*;
import hr.fer.inf.sus.gstarbe.model.dto.TeamRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TeamResponseDto;
import hr.fer.inf.sus.gstarbe.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hr.fer.inf.sus.gstarbe.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    final TeamRepository teamRepository;
    final TeamMapper teamMapper;
    final PlayerRepository playerRepository;
    final TeamsPlayersRepository teamsPlayersRepository;
    final TeamsPlayersMapper teamsPlayersMapper;
    final TournamentRepository tournamentRepository;
    final TournamentTeamRepository tournamentTeamRepository;
    final TournamentTeamMapper tournamentTeamMapper;

    @Override
    public TeamResponseDto createTeam(Long tournamentId, TeamRequestDto teamRequestDto) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new EntityNotFoundException("Tournament with given id not found."));

        Team team = teamRepository.save(teamMapper.toEntity(teamRequestDto));

        tournamentTeamRepository.save(tournamentTeamMapper.toEntity(tournamentId, team.getTId()));

        return getTeam(team.getTId());
    }

    @Override
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
        Team team = teamRepository.save(teamMapper.toEntity(teamRequestDto));
        return getTeam(team.getTId());
    }

    @Override
    public TeamResponseDto getTeam(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team with given id not found."));

        return teamMapper.toDto(team);
    }

    @Override
    public TeamResponseDto updateTeam(Long teamId, TeamRequestDto teamRequestDto) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team with given id not found."));

        teamMapper.toEntity(team, teamRequestDto);
        teamRepository.save(team);

        return getTeam(teamId);
    }

    @Override
    public void deleteTeam(Long teamId) {
        if (!teamRepository.existsById(teamId)) {
            throw new EntityNotFoundException("Team with given id not found.");
        }

        List<TournamentTeam> tournamentTeams = tournamentTeamRepository.findAllByTeamId(teamId);
        tournamentTeamRepository.deleteAll(tournamentTeams);

        teamRepository.deleteById(teamId);
    }
}
