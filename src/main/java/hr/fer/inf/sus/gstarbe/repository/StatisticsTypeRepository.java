package hr.fer.inf.sus.gstarbe.repository;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.StatisticsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsTypeRepository extends JpaRepository<StatisticsType, Long> {
}
