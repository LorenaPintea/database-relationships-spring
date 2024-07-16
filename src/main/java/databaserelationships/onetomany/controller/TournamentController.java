package databaserelationships.onetomany.controller;

import databaserelationships.onetomany.Registration;
import databaserelationships.onetomany.Tournament;
import databaserelationships.onetomany.service.RegistrationService;
import databaserelationships.onetomany.service.TournamentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    private final TournamentService tournamentService;
    private final RegistrationService registrationService;

    public TournamentController(TournamentService tournamentService, RegistrationService registrationService) {
        this.tournamentService = tournamentService;
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Tournament> allTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournament(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentService.addTournament(tournament);
    }

    @PutMapping("/{id}/add_registrations/{registration_id}")
    public Tournament addRegistration(@PathVariable Long id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistrationById(registration_id);
        System.out.println(registration);
        return tournamentService.addRegistration(id, registration);
    }

    @PutMapping("/{id}/remove_registrations/{registration_id}")
    public Tournament removeRegistration(@PathVariable Long id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistrationById(registration_id);
        System.out.println(registration);
        return tournamentService.removeRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public void removeTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
    }
}