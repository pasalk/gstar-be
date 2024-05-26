package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.Tournament;
import hr.fer.inf.sus.gstarbe.model.dbo.codebook.TournamentStatus;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentResponseDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {TournamentStructureMapper.class, CodebookMapper.class})
public abstract class TournamentMapper {

    @PersistenceContext
    EntityManager entityManager;

    Tournament toEntity(Long id) {
        return entityManager.getReference(Tournament.class, id);
    }


    @Mapping(source = "tournamentStructure", target = "tournamentStructureResponseDto")
    @Mapping(source = "TId", target = "t_id")
    @Mapping(source = "startDate", target = "start_date")
    @Mapping(source = "endDate", target = "end_date")
    @Mapping(source = "prizeFond", target = "prize_fond")
    //todo tournament structure id, teams
    public abstract TournamentResponseDto toDto(Tournament tournament);

    @Mapping(source = "tournamentStructureRequestDto", target = "tournamentStructure")
    @Mapping(source = "tournament_status_id", target = "tournamentStatus")
    //@Mapping(source = "organizerId", target = "organizer")
    @Mapping(source = "start_date", target = "startDate")
    @Mapping(source = "end_date", target = "endDate")
    //TODO teams
    public abstract Tournament toEntity(TournamentRequestDto tournamentRequestDto);

    @Mapping(source = "tournamentRequestDto.tournamentStructureRequestDto", target = "tournament.tournamentStructure")
    @Mapping(source = "tournamentRequestDto.tournament_status_id", target = "tournament.tournamentStatus")
    //@Mapping(source = "tournamentRequestDto.organizerId", target = "tournament.organizer")
    @Mapping(source = "tournamentRequestDto.start_date", target = "tournament.startDate")
    @Mapping(source = "tournamentRequestDto.end_date", target = "tournament.endDate")
    //TODO teams
    public abstract void toEntity(@MappingTarget Tournament tournament, TournamentRequestDto tournamentRequestDto);
}
