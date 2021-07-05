package com.projet.scootop.service.user.domain;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.domain.services.ComparatorParams;
import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Player;
import com.projet.scootop.functions.UserResume;
import com.projet.scootop.functions.search_engine.SearchPlayer;
import com.projet.scootop.mappers.services.ComparatorParamsMapper;
import com.projet.scootop.mappers.user.UserMapper;
import com.projet.scootop.mappers.user.UserTypeMapper;
import com.projet.scootop.mappers.user.domain.PlayerMapper;
import com.projet.scootop.model.services.ComparatorParamsDTO;
import com.projet.scootop.model.user.LoginDTO;
import com.projet.scootop.model.user.domain.FicheJoueurDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;
import com.projet.scootop.model.user.domain.PlayerSearchListDTO;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.domain.PlayerRepository;
import com.projet.scootop.service.user.UserService;
import com.projet.scootop.service.user.UserTypeService;

@Service
public class PlayerService {
	
	@Autowired private PlayerRepository playerRepository;
	@Autowired private TeamRepository teamRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private UserService userService;	
	@Autowired private UserTypeService userTypeService;	
	@Autowired private UserMapper userMapper;
	@Autowired private UserTypeMapper userTypeMapper;
	@Autowired private PlayerMapper mapper;
	@Autowired private ComparatorParamsMapper cpMapper;


    public ResponseEntity<LoginDTO> add(PlayerDTO playerDTO, HttpServletResponse response) throws Exception{
    	Player newPlayer = mapper.mapTo(playerDTO);
    	
    	//User user = userRepository.getOne(newPlayer.getUser().getId());
    	User user = userMapper.mapTo(playerDTO.getUser());
    	user.getUserTypes().add(userTypeService.getOneByType("Player"));
    	ResponseEntity<LoginDTO> loginDTO = userService.register(userMapper.mapToRegisterDTO(user), response);
    	//userRepository.save(user);
    	playerRepository.save(newPlayer);
        return loginDTO;
        
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

	public static String stripAccents(String s)
	{
		s = Normalizer.normalize(s, Normalizer.Form.NFD);
		s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		return s;
	}

	public List<PlayerSearchListDTO> searchPlayers(SearchPlayer params) throws JsonProcessingException {

		List<Player> players = playerRepository.findAll();
		System.out.println(players.size());

		if(params.getName() != null) {
			List<Player> toReturn = new ArrayList<>();
			String name = params.getName();
			Player searchedPlayer = null;
			if(name.split(" ").length != 1){
				searchedPlayer = playerRepository.searchPlayerByName(
						name.substring(0,name.indexOf(' ')),
						name.substring(name.indexOf(' ')+1)
				);
			}
			if(searchedPlayer == null){
				String nameWritten = params.getName().toLowerCase();
				for(Player player: players) {
					for(String mot : nameWritten.split(" ")) {
						System.out.println(mot);
						if(player.getUser().getFirstName().toLowerCase().contains(mot.toLowerCase())){
							toReturn.add(player);
						}
						else if(player.getUser().getLastName().toLowerCase().contains(mot.toLowerCase())){
							toReturn.add(player);
						}
					}
				}
			}
			else{
				players = new ArrayList<>();
				players.add(searchedPlayer);
			}
			if(toReturn.size() != 0){
				Set<Player> setPlayers = new HashSet<>(toReturn);
				List<Player> listPlayers = new ArrayList<>(setPlayers);
				players = listPlayers;
			}
			else{
				players = new ArrayList<>();
			}
		}
		if(params.getPostes() != null) {
			List<Player> toReturn = new ArrayList<>();

			for(Player player: players){
				for(Poste poste: player.getPostes()){
					for(Poste posteParam: params.getPostes()){
						if(poste.getId() == posteParam.getId()){
							toReturn.add(player);
						}
					}
				}
			}
			if(toReturn.size() != 0){
				Set<Player> setPlayers = new HashSet<>(toReturn);
				List<Player> listPlayers = new ArrayList<>(setPlayers);
				players = listPlayers;
			}
			else{
				players = new ArrayList<>();
			}
		}

		if(params.getTeam() != null) {
			List<Player> toReturn = new ArrayList<>();
			for(Player player: players){
				for(Team team: player.getTeams()){
					if(team.getId() == params.getTeam().getId()){
						toReturn.add(player);
					}
				}
			}
			if(toReturn.size() != 0){
				players = toReturn;
			}
			else{
				players = new ArrayList<>();
			}
		}

		System.out.println("players: "+new ObjectMapper().writeValueAsString(players));
		return mapper.mapToSearchDTO(players);
	}
}
