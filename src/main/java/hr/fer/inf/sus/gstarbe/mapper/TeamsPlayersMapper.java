package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.TeamsPlayers;
import hr.fer.inf.sus.gstarbe.model.dto.KeyValueDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TeamMapper.class, PlayerMapper.class})
public interface TeamsPlayersMapper {
    @Mapping(source = "tId", target = "team")
    @Mapping(source = "playerId", target = "player")
    TeamsPlayers toEntity(Long tId, Long playerId);
}
