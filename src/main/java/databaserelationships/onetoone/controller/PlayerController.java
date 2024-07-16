package databaserelationships.onetoone.controller;

import databaserelationships.onetoone.Player;
import databaserelationships.onetoone.PlayerProfile;
import databaserelationships.onetoone.service.PlayerProfileService;
import databaserelationships.onetoone.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerProfileService playerProfileService;

    public PlayerController(PlayerService playerService, PlayerProfileService playerProfileService) {
        this.playerService = playerService;
        this.playerProfileService = playerProfileService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id){
        return playerService.getAllPlayers().get(id);
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
}
