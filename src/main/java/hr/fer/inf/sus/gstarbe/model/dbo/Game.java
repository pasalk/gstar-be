package hr.fer.inf.sus.gstarbe.model.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "game")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "g_id", updatable = false, nullable = false)
    Long gId;

    @ManyToOne
    @JoinColumn(name = "first_team_id")
    Team firstTeam;

    @ManyToOne
    @JoinColumn(name = "second_team_id")
    Team secondTeam;

    @Column(name = "date")
    String date;

    @OneToOne
    @JoinColumn(name = "result_id")
    Result result;

    @ManyToOne
    @JoinColumn(name = "round_id")
    Round round;
}
