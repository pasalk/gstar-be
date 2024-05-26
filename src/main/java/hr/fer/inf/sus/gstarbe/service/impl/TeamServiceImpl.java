package hr.fer.inf.sus.gstarbe.service.impl;

import hr.fer.inf.sus.gstarbe.mapper.TeamMapper;
import hr.fer.inf.sus.gstarbe.mapper.TeamsPlayersMapper;
import hr.fer.inf.sus.gstarbe.model.dbo.Player;
import hr.fer.inf.sus.gstarbe.model.dbo.Team;
import hr.fer.inf.sus.gstarbe.model.dbo.TeamsPlayers;
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

    @Override
    public TeamResponseDto createTeam(TeamRequestDto teamRequestDto) {
        /*
        for(Long playerId: teamRequestDto.getPlayerIds()){
            if (!playerRepository.existsById(playerId)){
                throw new EntityNotFoundException("Unable to add nonexistent player to team.");
            }
        }

         */

        Team team = teamRepository.save(teamMapper.toEntity(teamRequestDto));
        /*
        for(Long playerId: teamRequestDto.getPlayerIds()){
            teamsPlayersRepository.save(teamsPlayersMapper.toEntity(team.getTId(), playerId));
        }

         */

        return getTeam(team.getTId());
    }

    @Override
    public TeamResponseDto getTeam(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team with given id not found."));

        //List<Player> players = team.getTeamPlayers().stream().map(TeamsPlayers::getPlayer).toList();
        return teamMapper.toDto(team);
    }

    @Override
    public TeamResponseDto updateTeam(Long teamId, TeamRequestDto teamRequestDto) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team with given id not found."));

        /*
        for(Long playerId: teamRequestDto.getPlayerIds()){
            if (!playerRepository.existsById(playerId)){
                throw new EntityNotFoundException("Unable to add nonexistent player to team.");
            }
        }

         */


        return null;
    }

    @Override
    public void deleteTeam(Long teamId) {

    }
}
