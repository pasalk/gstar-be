package hr.fer.inf.sus.gstarbe.model.dto;

import hr.fer.inf.sus.gstarbe.model.dbo.Statistics;
import hr.fer.inf.sus.gstarbe.model.dbo.TeamsPlayers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDto {
    Long t_id;
    String name;
    //avatar
    // List<KeyValueDto> players;
    String description;
}
