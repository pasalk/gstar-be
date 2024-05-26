package hr.fer.inf.sus.gstarbe.service;

import hr.fer.inf.sus.gstarbe.model.dto.TeamRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TeamResponseDto;

public interface TeamService {
    TeamResponseDto createTeam(TeamRequestDto teamRequestDto);

    TeamResponseDto getTeam(Long teamId);

    TeamResponseDto updateTeam(Long teamId, TeamRequestDto teamRequestDto);

    void deleteTeam(Long teamId);
}
