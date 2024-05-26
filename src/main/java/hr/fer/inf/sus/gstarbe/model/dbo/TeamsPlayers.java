package hr.fer.inf.sus.gstarbe.model.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams_players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamsPlayers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tp_id", updatable = false, nullable = false)
    Long tpId;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;

    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;

}
