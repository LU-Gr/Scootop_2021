package com.projet.scootop.service.domainuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.mappers.domainuser.PlayerMapper;
import com.projet.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.repository.domainconfiguration.CategoryRepository;
import com.projet.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.repository.user.UserRepository;
import java.util.List;

@Service
public class PlayerService {
	
	@Autowired
    private PlayerRepository playerRepository;
	
	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
   
	@Autowired
	private PlayerMapper mapper;

    public List<PlayerDTO> getAllPlayerByMatchSheetAndTeams(Long matchSheet, List<Team> teams){
        List<Player> players = playerRepository.findAllPlayerByMatchSheetsAndTeamsIn(matchSheet,teams);
        return mapper.mapTo(players);
    }


    public PlayerDTO add(PlayerDTO playerDTO){
    	Player newPlayer = mapper.mapTo(playerDTO);
    	categoryRepository.save(newPlayer.getCategory());
    	
    	userRepository.save(newPlayer.getUser());
    	playerRepository.save(newPlayer);
        return mapper.mapTo(newPlayer);
        
    }
    
    public PlayerDTO update(PlayerDTO playerDTO){
    	Player player = mapper.mapTo(playerDTO);
    	categoryRepository.save(player.getCategory());
        userRepository.save(player.getUser());
        playerRepository.save(player);
        return mapper.mapTo(player);
    }
    
    public PlayerDTO get(Long id) {
    	Player player = playerRepository.findById(id).orElse(null);
    	return mapper.mapTo(player);
    }
    
    public List<PlayerDTO> getAll() {
    	List<Player> players = playerRepository.findAll();
    	return mapper.mapTo(players);
    }
    
    public String delete(Long id){
        Player player=playerRepository.findById(id).orElse(null);
        playerRepository.delete(player);
        return "delete";
    }
}
