package hr.fer.inf.sus.gstarbe.service;

import hr.fer.inf.sus.gstarbe.model.dto.TeamRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TeamResponseDto;

public interface TeamService {
    TeamResponseDto createTeam(Long tournamentId, TeamRequestDto teamRequestDto);

    TeamResponseDto getTeam(Long teamId);

    TeamResponseDto updateTeam(Long teamId, TeamRequestDto teamRequestDto);

    void deleteTeam(Long teamId);

    TeamResponseDto createTeam(TeamRequestDto teamRequestDto);
}
