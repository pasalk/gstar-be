package hr.fer.inf.sus.gstarbe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequestDto {
    String name;
    TournamentStructureRequestDto tournamentStructureRequestDto;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String prizeFond;
    Long tournamentStatusId;
    Long organizerId;
}
