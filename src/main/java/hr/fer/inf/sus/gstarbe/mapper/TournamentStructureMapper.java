package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.TournamentStructure;
import hr.fer.inf.sus.gstarbe.model.dbo.codebook.TournamentStatus;
import hr.fer.inf.sus.gstarbe.model.dto.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CodebookMapper.class})
public abstract class TournamentStructureMapper {

    @PersistenceContext
    EntityManager entityManager;

    TournamentStructure tournamentStatusToEntity(Long id) {
        return entityManager.getReference(TournamentStructure.class, id);
    }

    @Mapping(source = "tournamentFormatId", target = "tournamentFormat")
    abstract TournamentStructure toEntity(TournamentStructureRequestDto tournamentStructureRequestDto);

    abstract TournamentStructureResponseDto toDto(TournamentStructure tournamentStructure);
}
