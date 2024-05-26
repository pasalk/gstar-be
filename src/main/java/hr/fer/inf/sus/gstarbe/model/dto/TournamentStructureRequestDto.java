package hr.fer.inf.sus.gstarbe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentStructureRequestDto {
    String gameGenre;
    String gameName;
    String rules;
    Long tournamentFormatId;
    Integer maxTeamNumber;
    String participationCriteria;
    List<PointSystemRequestDto> pointSystemRequestDtoList;
}
