package hr.fer.inf.sus.gstarbe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TournamentResponseDto {
    Long tId;
    String name;
    TournamentStructureResponseDto tournamentStructureResponseDto;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String prizeFond;
    KeyValueDto tournamentStatus;
    KeyValueDto organizer;
}
