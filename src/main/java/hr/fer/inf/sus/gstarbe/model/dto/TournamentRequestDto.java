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
    //tournament_structure_id
    TournamentStructureRequestDto tournamentStructureRequestDto;
    LocalDateTime start_date;
    LocalDateTime end_date;
    String prize_fond;
    Long tournament_status_id;
    //Long organizerId;
    List<TeamRequestDto> teams;
}
