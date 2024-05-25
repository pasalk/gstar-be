package hr.fer.inf.sus.gstarbe.model.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "followers_players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersPlayers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fp_id", updatable = false, nullable = false)
    Long fpId;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    Follower follower;

    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
}
