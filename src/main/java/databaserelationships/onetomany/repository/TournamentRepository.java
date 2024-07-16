package databaserelationships.onetomany.repository;

import databaserelationships.onetomany.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
