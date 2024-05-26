package hr.fer.inf.sus.gstarbe.model.dbo;

import hr.fer.inf.sus.gstarbe.model.dbo.codebook.TournamentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tournament")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id", updatable = false, nullable = false)
    Long tId;

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "tournament_structure_id")
    TournamentStructure tournamentStructure;

    @Column(name = "start_date")
    String startDate;

    @Column(name = "end_date")
    String endDate;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<TournamentTeam> tournamentTeams = new ArrayList<>();

    @Column(name = "prize_fond")
    String prizeFond;

    @ManyToOne
    @JoinColumn(name = "tournament_status_id")
    TournamentStatus tournamentStatus;



}
