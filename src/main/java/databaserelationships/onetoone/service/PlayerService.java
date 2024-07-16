package databaserelationships.onetoone.service;

import databaserelationships.onetoone.Player;
import databaserelationships.onetoone.PlayerProfile;
import databaserelationships.onetoone.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(int id){
        return playerRepository.findById(id).orElseThrow();
    }

    public Player addPlayer(Player player) {
        player.setId(0);
        return playerRepository.save(player);
    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    public Player assignProfile(int id, PlayerProfile profile) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setPlayerProfile(profile);
        return playerRepository.save(player);
    }

}
