package databaserelationships.bimanytomany.controller;

import databaserelationships.bimanytomany.Player;
import databaserelationships.bimanytomany.PlayerProfile;
import databaserelationships.bimanytomany.Registration;
import databaserelationships.bimanytomany.service.PlayerProfileService;
import databaserelationships.bimanytomany.service.PlayerService;
import databaserelationships.bimanytomany.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerProfileService playerProfileService;
    private final RegistrationService registrationService;

    public PlayerController(PlayerService playerService, PlayerProfileService playerProfileService, RegistrationService registrationService) {
        this.playerService = playerService;
        this.playerProfileService = playerProfileService;
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.allPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id){
        return playerService.allPlayers().get(id);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public Player assignDetail(@PathVariable int id, @PathVariable int profile_id) {
        PlayerProfile profile = playerProfileService.getPlayerProfile(profile_id);
        return playerService.assignProfile(id, profile);
    }

    @PutMapping("/{id}/registrations/{registration_id}")
    public Player assignRegistration(@PathVariable int id, @PathVariable int registration_id) {
        Registration registration = registrationService.getRegistrationById(registration_id);
        return playerService.assignRegistration(id, registration);
    }

}
