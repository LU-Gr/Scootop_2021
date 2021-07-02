package com.projet.scootop.service.user.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.services.ComparatorParams;
import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.functions.UserResume;
import com.projet.scootop.functions.search_engine.SearchPlayer;
import com.projet.scootop.mappers.services.ComparatorParamsMapper;
import com.projet.scootop.mappers.user.domain.PlayerMapper;
import com.projet.scootop.model.services.ComparatorParamsDTO;
import com.projet.scootop.model.user.domain.FicheJoueurDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;
import com.projet.scootop.model.user.domain.PlayerSearchListDTO;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.domain.PlayerRepository;
import com.projet.scootop.service.user.UserTypeService;

@Service
public class PlayerService {
	
	@Autowired private PlayerRepository playerRepository;
	@Autowired private UserRepository userRepository;   
	@Autowired private UserTypeService userTypeService;	
	@Autowired private PlayerMapper mapper;
	@Autowired private ComparatorParamsMapper cpMapper;


    public PlayerDTO add(PlayerDTO playerDTO){
    	Player newPlayer = mapper.mapTo(playerDTO);
    	User user = userRepository.getOne(newPlayer.getUser().getId());
    	user.getUserTypes().add(userTypeService.getOneByType("Player"));
    	userRepository.save(user);
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
		ficheJoueur.setNbMatchWon(ur.getMatchWon());
		ficheJoueur.setNbGoals(ur.getGoals());
		ficheJoueur.setNbShoots(ur.getShoots());
		ficheJoueur.setNbPasses(ur.getPasses());
		ficheJoueur.setNbAssists(ur.getAssists());
		ficheJoueur.setNbSkills(ur.getActions());
		ficheJoueur.setNbSucceededSkills(ur.getActionsSuccess());
		ficheJoueur.setNbMinutePlayed(0);
		ficheJoueur.setNbSucceededPasses(ur.getPassesSuccess());
		ficheJoueur.setNbShootsInBox(ur.getShootsInBox());
		ficheJoueur.setNbSucceededDribbles(ur.getDribblesSuccess());
		ficheJoueur.setNbBallsRecuperes(ur.getBallsPlayed());
		ficheJoueur.setNbBallsPlayed(ur.getBallsPlayed());
		ficheJoueur.setNbBallsLost(ur.getBallsLost());
		System.out.println(ficheJoueur.toString());
		return ficheJoueur;
	}

	public List<PlayerSearchListDTO> searchPlayers(SearchPlayer params) throws JsonProcessingException {
		
		List<Player> players = playerRepository.findAll();
		System.out.println(players.size());
		
		
		
		if(params.getName() != null) {
			for(Player player: players) {
				for(String mot : params.getName().split(" ")) {
					System.out.println(mot);
					
				}
			}
		}
		
		if(params.getPostes() != null) {
			
		}
		System.out.println(params.toString());
		if(params.getTeam() != null) {
			for(Player player: players) {
				int count = (int) player.getTeams()
						.stream().filter(p -> p.getId() == params.getTeam().getId()).count();
				/*
				Collection<Team> similar = new HashSet<Team>(params.getTeams());
				similar.retainAll(p.getTeams());*/
				System.out.println(count);
			}	
		}
		
		//Player p = new Player();
		//p.setTeams(params.getTeams());
		//p.setPostes(params.getPostes());
		//p.setUser(new User());
		//p.getUser().set
		
		//Player p = playerRepository.findById((long) 1).orElse(null);
		//List<Long> teams = new ArrayList<>();
		//teams.add(3l);
		//teams.add(p.getTeams().get(0));
		
		
		System.out.println("players: "+new ObjectMapper().writeValueAsString(players));
		//List<Player> players = playerRepository.searchPlayers(params.getTeams());//playerRepository.findAll(Example.of(p));
		return mapper.mapToSearchDTO(players);
	}
}
