package hr.fer.inf.sus.gstarbe.model.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tournament_team")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tt_id", updatable = false, nullable = false)
    Long ttId;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;

    @Column(name = "points")
    Integer points;
}
