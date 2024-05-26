package hr.fer.inf.sus.gstarbe.repository;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.TournamentFormat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentFormatRepository extends JpaRepository<TournamentFormat, Long> {
}
