package hr.fer.inf.sus.gstarbe.model.dbo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id", updatable = false, nullable = false)
    Long tId;

    @OneToOne
    @JoinColumn(name = "statistics_id")
    Statistics statistics;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<TeamsPlayers> teamPlayers = new ArrayList<>();

    @Column(name = "description")
    String description;
}
