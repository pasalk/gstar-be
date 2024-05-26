package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.Tournament;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.TournamentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {TournamentStructureMapper.class, CodebookMapper.class})
public interface TournamentMapper {

    @Mapping(source = "tournamentStructure", target = "tournamentStructureResponseDto")
    TournamentResponseDto toDto(Tournament tournament);

    @Mapping(source = "tournamentStructureRequestDto", target = "tournamentStructure")
    @Mapping(source = "tournamentStatusId", target = "tournamentStatus")
    @Mapping(source = "organizerId", target = "organizer")
    Tournament toEntity(TournamentRequestDto tournamentRequestDto);

    @Mapping(source = "tournamentRequestDto.tournamentStructureRequestDto", target = "tournament.tournamentStructure")
    @Mapping(source = "tournamentRequestDto.tournamentStatusId", target = "tournament.tournamentStatus")
    @Mapping(source = "tournamentRequestDto.organizerId", target = "tournament.organizer")
    void toEntity(@MappingTarget Tournament tournament, TournamentRequestDto tournamentRequestDto);
}
