package databaserelationships.onetomany.service;

import databaserelationships.onetomany.Registration;
import databaserelationships.onetomany.Tournament;
import databaserelationships.onetomany.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(Long id) {
        return tournamentRepository.findById(id).orElse(null);
    }

    public Tournament addTournament(Tournament tournament) {
        tournament.setId(0);
        return tournamentRepository.save(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    public Tournament addRegistration(Long id, Registration registration) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow();
        tournament.addRegistration(registration);
        return tournamentRepository.save(tournament);
    }

    public Tournament removeRegistration(Long id, Registration registration) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow();
        tournament.removeRegistration(registration);
        return tournamentRepository.save(tournament);
    }
}
