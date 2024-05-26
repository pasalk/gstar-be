package hr.fer.inf.sus.gstarbe.model.dbo.codebook;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "result_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rt_id", updatable = false, nullable = false)
    Long rtId;

    @Column(name = "value")
    String value;
}
