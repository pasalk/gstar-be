package hr.fer.inf.sus.gstarbe.repository;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
