package hr.fer.inf.sus.gstarbe.model.dbo.codebook;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tournament_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ts_id", updatable = false, nullable = false)
    Long rId;

    @Column(name = "value")
    String value;

}
