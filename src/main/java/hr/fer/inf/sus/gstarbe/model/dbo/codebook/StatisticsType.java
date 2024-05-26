package hr.fer.inf.sus.gstarbe.model.dbo.codebook;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "statistics_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id", updatable = false, nullable = false)
    Long rId;

    @Column(name = "value")
    String value;

}
