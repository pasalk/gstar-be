package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.TournamentStructure;
import hr.fer.inf.sus.gstarbe.model.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CodebookMapper.class})
public interface TournamentStructureMapper {

    @Mapping(source = "tournamentFormatId", target = "tournamentFormat")
    TournamentStructure toEntity(TournamentStructureRequestDto tournamentStructureRequestDto);

    //TODO pointsystem mapping
    TournamentStructureResponseDto toDto(TournamentStructure tournamentStructure);
}
