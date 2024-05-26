package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.Player;
import hr.fer.inf.sus.gstarbe.model.dto.KeyValueDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PlayerMapper {
    @PersistenceContext
    EntityManager entityManager;

    Player toEntity(Long id) {
        return entityManager.getReference(Player.class, id);
    }

    @Mapping(source = "PId", target = "key")
    @Mapping(source = "user.username", target = "value")
    public abstract KeyValueDto toKeyValueDto(Player player);

}
