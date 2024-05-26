package hr.fer.inf.sus.gstarbe.mapper;

import hr.fer.inf.sus.gstarbe.model.dbo.PointSystem;
import hr.fer.inf.sus.gstarbe.model.dto.PointSystemRequestDto;
import hr.fer.inf.sus.gstarbe.model.dto.PointSystemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {TournamentStructureMapper.class, CodebookMapper.class})
public interface PointSystemMapper {

    @Mapping(source = "tournamentStructureId", target = "tournamentStructure")
    @Mapping(source = "pointSystemRequestDto.resultTypeId", target = "resultType")
    @Mapping(source = "pointSystemRequestDto.value", target = "value")
    PointSystem toEntity(PointSystemRequestDto pointSystemRequestDto, Long tournamentStructureId);

    @Mapping(source = "pointSystemRequestDto.resultTypeId", target = "pointSystem.resultType")
    @Mapping(source = "pointSystemRequestDto.value", target = "pointSystem.value")
    void toEntity(@MappingTarget PointSystem pointSystem, PointSystemRequestDto pointSystemRequestDto);

    PointSystemResponseDto toDto(PointSystem pointSystem);
}
