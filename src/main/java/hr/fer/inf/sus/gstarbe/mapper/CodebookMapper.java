package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.Organizer;
import hr.fer.inf.sus.gstarbe.model.dbo.TournamentStructure;
import hr.fer.inf.sus.gstarbe.model.dbo.codebook.*;
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
    public abstract KeyValueDto tournamentStatusToDto(TournamentStatus tournamentStatus);

    TournamentStructure tournamentStructureToEntity(Long id) {
        return entityManager.getReference(TournamentStructure.class, id);
    }
    Organizer organizerToEntity(Long id) {
        return entityManager.getReference(Organizer.class, id);
    }

    @Mapping(source = "organizerId", target = "key")
    @Mapping(source = "name", target = "value")
    public abstract KeyValueDto organizerToDto(Organizer organizer);


    TournamentFormat tournamentFormatToEntity(Long id) {
        return entityManager.getReference(TournamentFormat.class, id);
    }

    @Mapping(source = "tfId", target = "key")
    public abstract KeyValueDto tournamentFormatToDto(TournamentFormat tournamentFormat);

    ResultType resultTypeToEntity(Long id) {
        return entityManager.getReference(ResultType.class, id);
    }

    @Mapping(source = "rtId", target = "key")
    public abstract KeyValueDto resultTypeToDto(ResultType resultType);

    @Mapping(source = "stId", target = "key")
    public abstract KeyValueDto statisticsTypeToDto(StatisticsType statisticsType);

    @Mapping(source = "utId", target = "key")
    public abstract KeyValueDto userTypeToDto(UserType userType);

    @Mapping(source = "tsId", target = "key")
    @Mapping(source = "gameName", target = "value")
    public abstract KeyValueDto tournamentStructureToDto(TournamentStructure tournamentStructure);
}
