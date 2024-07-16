package databaserelationships.onetoone.service;

import databaserelationships.onetoone.PlayerProfile;
import databaserelationships.onetoone.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class PlayerProfileService {
    private final PlayerProfileRepository playerProfileRepository;

    public PlayerProfileService(PlayerProfileRepository playerProfileRepository) {
        this.playerProfileRepository = playerProfileRepository;
    }

    public List<PlayerProfile> getAllPlayerProfiles() {
        return playerProfileRepository.findAll();
    }

    public PlayerProfile getPlayerProfile(int id){
        return playerProfileRepository.findById(id).orElseThrow();
    }

    public PlayerProfile addPlayerProfile(PlayerProfile profile) {
        profile.setId(0);
        return playerProfileRepository.save(profile);
    }

    public void deletePlayerProfile(int id) {
        //Get the Profile
        PlayerProfile profile = getPlayerProfile(id);
        //Set the profile field on the player to null
        profile.getPlayer().setPlayerProfile(null);
        //Set the player field on the profile to null
        profile.setPlayer(null);
        //Delete the profile object without affecting the player object
        playerProfileRepository.delete(profile);
    }
}
