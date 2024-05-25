package hr.fer.inf.sus.gstarbe.model.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "followers_tournaments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersTournaments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ft_id", updatable = false, nullable = false)
    Long ftId;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    Follower follower;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    Tournament tournament;
}
