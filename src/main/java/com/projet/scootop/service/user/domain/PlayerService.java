package com.projet.scootop.service.user.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.services.ComparatorParams;
import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.functions.UserResume;
import com.projet.scootop.mappers.services.ComparatorParamsMapper;
import com.projet.scootop.mappers.user.domain.PlayerMapper;
import com.projet.scootop.model.services.ComparatorParamsDTO;
import com.projet.scootop.model.user.domain.FicheJoueurDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;
import com.projet.scootop.repository.user.domain.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired private PlayerRepository playerRepository;
	
	@Autowired private PlayerMapper mapper;
	@Autowired private ComparatorParamsMapper cpMapper;


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
    	System.out.println(player.toString());
    	PlayerDTO p = mapper.mapToDTO(player);
    	System.out.println(p.toString());
    	return p;
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
    
    public List<FicheJoueurDTO> compareTwoPlayers(ComparatorParamsDTO params){
    	List<FicheJoueurDTO> comparator = new ArrayList<>();
    	ComparatorParams cp = cpMapper.mapTo(params);
    	comparator.add(generateUserResume(cp.getCompetitionType(), cp.getSaison(), cp.getTeam(), cp.getPlayerAId()));
    	comparator.add(generateUserResume(cp.getCompetitionType(), cp.getSaison(), cp.getTeam(), cp.getPlayerBId()));
    	return comparator;
    }


	public FicheJoueurDTO getUserResume(ComparatorParamsDTO params) {
		System.out.println(params.toString());
		ComparatorParams cp = cpMapper.mapTo(params);
		System.out.println(cp.toString());
		return generateUserResume(cp.getCompetitionType(), cp.getSaison(), cp.getTeam(), cp.getPlayerAId());
	}
	
	private FicheJoueurDTO generateUserResume(CompetitionType competitionType, Saison saison, Team team, Long playerId) {
		if(playerId == null) {
			return null;
		}
		Player player = playerRepository.getOne(playerId);
		UserResume ur = new UserResume(
				player, 
				competitionType, 
				saison,
				team);
		///System.out.println(ur.toString());
		FicheJoueurDTO ficheJoueur = new FicheJoueurDTO();
		ficheJoueur.setPlayerFirstName(player.getUser().getFirstName());
		ficheJoueur.setPlayerLastName(player.getUser().getLastName());
		ficheJoueur.setPhotoUrl(player.getPhotoUrl());
		ficheJoueur.setNbMatchPlayed(ur.getMatchPlayed());
		ficheJoueur.setNbGoals(ur.getGoals());
		ficheJoueur.setNbMinutePlayed(0);
		ficheJoueur.setNbSuccededPasses(ur.getAssistsSuccess());
		ficheJoueur.setNbShootsInBox(ur.getShootsInBox());
		ficheJoueur.setNbSuccededDribbles(ur.getDribblesSuccess());
		ficheJoueur.setNbBallonsRecuperes(ur.getBallsPlayed());
		System.out.println(ficheJoueur.toString());
		return ficheJoueur;
	}
}
