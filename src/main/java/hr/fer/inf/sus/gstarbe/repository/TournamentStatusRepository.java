package hr.fer.inf.sus.gstarbe.repository;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.TournamentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentStatusRepository extends JpaRepository<TournamentStatus, Long> {
}
