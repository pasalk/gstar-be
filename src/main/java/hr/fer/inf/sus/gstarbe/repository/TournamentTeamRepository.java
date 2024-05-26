package hr.fer.inf.sus.gstarbe.repository;

import hr.fer.inf.sus.gstarbe.model.dbo.TournamentTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TournamentTeamRepository extends JpaRepository<TournamentTeam, Long> {
    @Query("""
            SELECT tt FROM TournamentTeam tt
            WHERE tt.tournament.tId = :id
            AND tt.team.name = :name
            """)
    Optional<TournamentTeam> findByTournamentIdAndTeamName(@Param("id") Long tournamentId, @Param("name") String name);

    @Query("""
             SELECT tt FROM TournamentTeam tt
             WHERE tt.tournament.tId = :id
            """)
    List<TournamentTeam> findAllByTournamentId(@Param("id") Long tournamentId);

    @Query("""
             SELECT tt FROM TournamentTeam tt
             WHERE tt.team.tId = :id
            """)
    List<TournamentTeam> findAllByTeamId(Long teamId);
}
