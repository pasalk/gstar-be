package hr.fer.inf.sus.gstarbe.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentRequestDto {
    String name;
    Long tournament_structure_id;
    String start_date;
    String end_date;
    String prize_fond;
    Long tournament_status_id;
    List<TeamRequestDto> teams;
}
