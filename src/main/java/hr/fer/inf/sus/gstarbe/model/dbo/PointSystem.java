package hr.fer.inf.sus.gstarbe.model.dbo;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.ResultType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "point_system")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ps_id", updatable = false, nullable = false)
    Long psId;

    @ManyToOne
    @JoinColumn(name = "tournament_structure_id")
    TournamentStructure tournamentStructure;

    @ManyToOne
    @JoinColumn(name = "result_type_id")
    ResultType resultType;

    @Column(name = "value")
    Integer value;

}
