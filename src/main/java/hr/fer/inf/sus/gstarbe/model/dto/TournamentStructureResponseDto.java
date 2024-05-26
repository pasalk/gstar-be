package hr.fer.inf.sus.gstarbe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentStructureResponseDto {
    Long tsId;
    String gameGenre;
    String gameName;
    String rules;
    KeyValueDto tournamentFormat;
    Integer maxTeamNumber;
    String participationCriteria;
    List<PointSystemResponseDto> pointSystemResponseDtoList;
}
