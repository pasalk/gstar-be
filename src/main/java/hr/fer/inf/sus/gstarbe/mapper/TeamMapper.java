package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.Player;
import hr.fer.inf.sus.gstarbe.model.dbo.Team;
import hr.fer.inf.sus.gstarbe.model.dto.TeamRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TeamResponseDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public abstract class TeamMapper {

    @PersistenceContext
    EntityManager entityManager;

    Team toEntity(Long id) {
        return entityManager.getReference(Team.class, id);
    }

    public abstract Team toEntity(TeamRequestDto teamRequestDto);

    @Mapping(source = "TId", target = "t_id")
    public abstract TeamResponseDto toDto(Team team);

    //TODO
    public abstract void toEntity(@MappingTarget Team team, TeamRequestDto teamRequestDto);
}
