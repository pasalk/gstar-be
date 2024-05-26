package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.TournamentTeam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TournamentMapper.class, TeamMapper.class})
public interface TournamentTeamMapper {

    @Mapping(source = "tournamentId", target = "tournament")
    @Mapping(source = "teamId", target = "team")
    TournamentTeam toEntity(Long tournamentId, Long teamId);
}
