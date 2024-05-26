package hr.fer.inf.sus.gstarbe.repository;

import hr.fer.inf.sus.gstarbe.model.dbo.PointSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PointSystemRepository extends JpaRepository<PointSystem, Long> {

    @Query("""
            SELECT ps FROM PointSystem ps
            WHERE ps.tournamentStructure.tsId = :tsId
            AND ps.resultType.rtId = :rtId
            """)
    Optional<PointSystem> findByTournamentStructureIdAndResultTypeId(@Param("tsId") Long tsId, @Param("rtId") Long rtId);
}
