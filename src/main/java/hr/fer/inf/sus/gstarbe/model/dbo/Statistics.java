package hr.fer.inf.sus.gstarbe.model.dbo;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.StatisticsType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id", updatable = false, nullable = false)
    Long sId;

    @ManyToOne
    @JoinColumn(name = "statistics_type_id")
    StatisticsType statisticsType;
}
