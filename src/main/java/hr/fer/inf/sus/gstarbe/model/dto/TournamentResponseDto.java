package hr.fer.inf.sus.gstarbe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TournamentResponseDto {
    Long t_id;
    String name;
    //Long tournament_structure_id;
    TournamentStructureResponseDto tournamentStructureResponseDto;
    LocalDateTime start_date;
    LocalDateTime end_date;
    String prize_fond;
    //KeyValueDto tournamentStatus;
    Long tournament_status_id;
    //KeyValueDto organizer;
    List<TeamResponseDto> teams;
}
