package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.Organizer;
import hr.fer.inf.sus.gstarbe.model.dbo.codebook.TournamentFormat;
import hr.fer.inf.sus.gstarbe.model.dbo.codebook.TournamentStatus;
import hr.fer.inf.sus.gstarbe.model.dto.KeyValueDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CodebookMapper {
    @PersistenceContext
    EntityManager entityManager;

    TournamentStatus tournamentStatusToEntity(Long id) {
        return entityManager.getReference(TournamentStatus.class, id);
    }

    @Mapping(source = "tsId", target = "key")
    abstract KeyValueDto tournamentStatusToDto(TournamentStatus tournamentStatus);

    Organizer organizerToEntity(Long id) {
        return entityManager.getReference(Organizer.class, id);
    }

    @Mapping(source = "organizerId", target = "key")
    @Mapping(source = "name", target = "value")
    abstract KeyValueDto organizerToDto(Organizer organizer);


    TournamentFormat tournamentFormatToEntity(Long id) {
        return entityManager.getReference(TournamentFormat.class, id);
    }

    @Mapping(source = "tfId", target = "key")
    abstract KeyValueDto tournamentFormatToDto(TournamentFormat tournamentFormat);
}
