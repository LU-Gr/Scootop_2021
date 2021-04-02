package com.projet.scootop.scootop.service.domainuser;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.scootop.model.services.WearableDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.CategoryRepository;
import com.projet.scootop.scootop.repository.domainconfiguration.ClubRepository;
import com.projet.scootop.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.scootop.service.UserService;
import com.projet.scootop.scootop.service.domaineconfiguration.CategoryService;
import com.projet.scootop.scootop.service.domaineconfiguration.ClubService;
import com.projet.scootop.scootop.service.domaineconfiguration.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private ClubService clubService;
    @Autowired
    private UserService userService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    public PlayerRepository playerRepository;

    public List<PlayerDTO> getAllPlayerByMatchSheetAndTeams(int matchSheet, List<Team> teams){

        List<Player> players = playerRepository.findAllPlayerByMatchSheetsAndTeamsIn(matchSheet,teams);
        return players.stream().map(player ->PlayerDTO.get(player.id,player.club, player.teams, player.category, player.evaluation, player.birthday, player.taille, player.poids, player.vma, player.nationalite, player.origin, player.interaction, player.strongFoot, player.weekFoot, player.playerHead,player.statisticalSheets, player.matchSheets,player.videos,player.user)).collect(Collectors.toList());

    }


    public Player add(PlayerDTO playerDTO,int TeamId){
        categoryService.updateEntity(playerDTO.category);
        clubService.updateEntity(playerDTO.club);
        teamService.updateEntity(playerDTO.teams.get(TeamId));
        userService.updateEntity(playerDTO.user);
        Player newPlayer = new Player(playerDTO.club, playerDTO.teams, playerDTO.category, playerDTO.evaluation, playerDTO.birthday, playerDTO.taille, playerDTO.poids, playerDTO.vma, playerDTO.nationalite, playerDTO.origin, playerDTO.interaction, playerDTO.strongFoot, playerDTO.weekFoot, playerDTO.statisticalSheets, playerDTO.playerHead, playerDTO.matshSheets,playerDTO.videos,false,playerDTO.user);
        return playerRepository.save(newPlayer);
    }
    // a optimiser, la requete ne nous permet pas de creer l'ensemble des elements d
    public Player update(PlayerDTO playerDTO, Integer id){
        categoryService.updateEntity(playerDTO.category);
        clubService.updateEntity(playerDTO.club);
        teamService.updatePlayerList(playerDTO.teams, playerDTO.teams.get(id));
        userService.updateEntity(playerDTO.user);
        Player newPlayer = new Player(playerDTO.club, playerDTO.teams, playerDTO.category, playerDTO.evaluation, playerDTO.birthday, playerDTO.taille, playerDTO.poids, playerDTO.vma, playerDTO.nationalite, playerDTO.origin, playerDTO.interaction, playerDTO.strongFoot, playerDTO.weekFoot, playerDTO.statisticalSheets, playerDTO.playerHead, playerDTO.matshSheets,playerDTO.videos,false,playerDTO.user);
        newPlayer.id=id;
        return playerRepository.save(newPlayer);
    }
    public Player get( Integer id) {
            return playerRepository.findById(id).orElse(null);
    }
    public List<Player> getAll() {
            return playerRepository.findAll();
    }
    public String delete(Integer id){
        Player player=playerRepository.findById(id).orElse(null);
        playerRepository.delete(player);
        return "delete";
    }
}
