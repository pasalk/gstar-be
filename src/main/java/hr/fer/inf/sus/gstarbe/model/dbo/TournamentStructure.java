package hr.fer.inf.sus.gstarbe.model.dbo;

import hr.fer.inf.sus.gstarbe.model.enums.TournamentFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tournament_structure")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ts_id", updatable = false, nullable = false)
    Long tsId;

    @Column(name = "game_genre")
    String gameGenre;

    @Column(name = "game_name")
    String gameName;

    //todo rules

    @Column(name = "tournament_format")
    TournamentFormat tournamentFormat;

    @Column(name = "max_team_number")
    Integer maxTeamNumber;

    @Column(name = "participation_criteria")
    String participationCriteria;

    //todo point system
}
