package hr.fer.inf.sus.gstarbe.model.dbo;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id", updatable = false, nullable = false)
    Long uId;

    @Column(name = "username")
    String username;

    @Column(name = "email")
    String email;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    UserType userType;

    @ManyToOne
    @JoinColumn(name = "user_subtype_id")
    UserType userSubtype;
}
