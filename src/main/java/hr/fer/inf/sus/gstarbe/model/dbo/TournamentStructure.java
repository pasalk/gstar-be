package hr.fer.inf.sus.gstarbe.model.dbo;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.TournamentFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "rules")
    String rules;

    @ManyToOne
    @JoinColumn(name = "tournament_format_id")
    TournamentFormat tournamentFormat;

    @Column(name = "max_team_number")
    Integer maxTeamNumber;

    @Column(name = "participation_criteria")
    String participationCriteria;

    @OneToMany(mappedBy = "tournamentStructure", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<PointSystem> pointSystems = new ArrayList<>();

}
