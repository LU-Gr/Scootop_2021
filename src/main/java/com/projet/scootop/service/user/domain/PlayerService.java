package com.projet.scootop.service.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.functions.UserResume;
import com.projet.scootop.mappers.configuration.CompetitionTypeMapper;
import com.projet.scootop.mappers.tools.SaisonMapper;
import com.projet.scootop.mappers.tools.TeamMapper;
import com.projet.scootop.mappers.user.domain.PlayerMapper;
import com.projet.scootop.model.user.domain.FicheJoueurDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;
import com.projet.scootop.repository.configuration.CategoryRepository;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.domain.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {
	
	@Autowired private PlayerRepository playerRepository;
	
	@Autowired private UserRepository userRepository;
    
    @Autowired private CategoryRepository categoryRepository;
   
	@Autowired private PlayerMapper mapper;
	@Autowired private SaisonMapper sMapper;
	@Autowired private CompetitionTypeMapper ctMapper;
	@Autowired private TeamMapper tMapper;


    public PlayerDTO add(PlayerDTO playerDTO){
    	System.out.println(playerDTO.toString());
    	Player newPlayer = mapper.mapTo(playerDTO);
    	System.out.println(newPlayer.toString());
    	playerRepository.save(newPlayer);
        return mapper.mapToDTO(newPlayer);
        
    }
    
    public PlayerDTO update(PlayerDTO playerDTO){
    	Player player = mapper.mapTo(playerDTO);
        playerRepository.save(player);
        return mapper.mapToDTO(player);
    }
    
    public PlayerDTO get(Long id) {
    	Player player = playerRepository.findById(id).orElse(null);
    	return mapper.mapToDTO(player);
    }
    
    public List<PlayerDTO> getAll() {
    	List<Player> players = playerRepository.findAll();
    	return mapper.mapToDTO(players);
    }
    
    public String delete(Long id){
        Player player=playerRepository.findById(id).orElse(null);
        playerRepository.delete(player);
        return "delete";
    }


	public FicheJoueurDTO getFicheJoueur(FicheJoueurDTO ficheJoueur) {
		if(ficheJoueur.getPlayerId() == null) {
			return null;
		}
		Player player = playerRepository.getOne(ficheJoueur.getPlayerId());
		ficheJoueur.setPlayerFirstName(player.getUser().getFirstName());
		ficheJoueur.setPlayerFirstName(player.getUser().getLastName());
		ficheJoueur.setPhotoUrl(player.getPhotoUrl());
		UserResume ur = new UserResume(
				player, 
				ctMapper.mapTo(ficheJoueur.getCompetitionType()), 
				sMapper.mapTo(ficheJoueur.getSaison()),
				tMapper.mapTo(ficheJoueur.getTeam()));
		ficheJoueur.setNbMatchPlayed(ur.getMatchPlayed());
		ficheJoueur.setNbGoals(ur.getGoals());
		ficheJoueur.setNbMinutePlayed(0);
		ficheJoueur.setNbSuccededPasses(ur.getAssistsSuccess());
		ficheJoueur.setNbShootsInBox(ur.getShootsInBox());
		ficheJoueur.setNbSuccededDribbles(ur.getDribblesSuccess());
		ficheJoueur.setNbBallonsRecuperes(ur.getBallsPlayed());
		
		
		return ficheJoueur;
	}
}
