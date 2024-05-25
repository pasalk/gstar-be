package hr.fer.inf.sus.gstarbe.model.dbo;

import hr.fer.inf.sus.gstarbe.model.enums.UserType;
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

    @Column(name = "user_type")
    UserType userType;

    @Column(name = "user_subtype")
    UserType userSubtype;
}
