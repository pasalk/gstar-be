package hr.fer.inf.sus.gstarbe.model.dbo.codebook;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tournament_format")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TournamentFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tf_id", updatable = false, nullable = false)
    Long rId;

    @Column(name = "value")
    String value;

}
