package hr.fer.inf.sus.gstarbe.model.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", updatable = false, nullable = false)
    Long pId;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "avatar")
    String avatar;

    @Column(name = "biography")
    String biography;

    @Column(name = "preferred_games")
    String preferredGames;

    @OneToOne
    @JoinColumn(name = "statistics_id")
    Statistics statistics;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<TeamsPlayers> playerTeams = new ArrayList<>();
}
