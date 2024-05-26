package hr.fer.inf.sus.gstarbe.model.dbo.codebook;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ut_id", updatable = false, nullable = false)
    Long utId;

    @Column(name = "value")
    String value;

}
