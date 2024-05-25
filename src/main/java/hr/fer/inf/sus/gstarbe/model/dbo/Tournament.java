package hr.fer.inf.sus.gstarbe.model.dbo;

import hr.fer.inf.sus.gstarbe.model.enums.TournamentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    LocalDateTime startDate;

    @Column(name = "end_date")
    LocalDateTime endDate;

    //todo rang_list

    @Column(name = "prize_fond")
    String prizeFond;

    @Column(name = "tournament_status")
    TournamentStatus tournamentStatus;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    Organizer organizer;


}
