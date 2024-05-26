package hr.fer.inf.sus.gstarbe.model.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id", updatable = false, nullable = false)
    Long rId;

    @OneToOne
    @JoinColumn(name = "winner_id")
    Team team;

    @Column(name = "first_score")
    Integer firstScore;

    @Column(name = "second_score")
    Integer secondScore;
}
