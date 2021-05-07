package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.repository.configuration.CategoryRepository;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.domainuser.CoachRepository;
import com.projet.scootop.repository.user.domainuser.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    public TeamRepository teamRepository;

    @Autowired
    public PlayerRepository playerRepository;
    @Autowired
    public CoachRepository coachRepository;
    @Autowired
    public CategoryRepository categoryRepository;
    public Team addTeam(TeamDTO teamDTO) throws Exception {
        coachRepository.saveAll(teamDTO.getCoaches());
        categoryRepository.save(teamDTO.getCategory());
        Team team = new Team(teamDTO.getClub(),teamDTO.getCategory(),teamDTO.getPlayers(),teamDTO.getCoaches());
        return teamRepository.save(team);

    }
    public Team update(TeamDTO teamDTO,Long id) throws Exception {
        coachRepository.saveAll(teamDTO.getCoaches());
        categoryRepository.save(teamDTO.getCategory());
        Team team = new Team(teamDTO.getClub(),teamDTO.getCategory(),teamDTO.getPlayers(),teamDTO.getCoaches());
        team.setId(id);
        return teamRepository.save(team);

    }
    public Team updateEntity(Team team) {
        coachRepository.saveAll(team.getCoaches());
        System.out.println("aaaa");
        categoryRepository.save(team.getCategory());
        System.out.println("bbbbb");

        return teamRepository.save(team);

    }

    public Team updatePlayerList(List<Team> teams, Team team) {
        playerRepository.saveAll(teams.get(team.getId().intValue()).getPlayers());
        System.out.println("aaaa");
        categoryRepository.save(team.getCategory());
        System.out.println("bbbbb");

        return teamRepository.save(team);

    }
    public TeamDTO get(Long id){


        Team team = teamRepository.findById(id).orElse(null);
        if(team==null){
            return null;
        }
        return TeamDTO.get(team.getId(), team.getClub(), team.getName(),team.getCoaches(),team.getPlayers(), team.getCategory());
    }

    public String delete(Long id){
        Team team = teamRepository.findById(id).orElse(null);
        if(team==null){
            return null;
        }
        teamRepository.deleteById(id);
        return "Deleted";
    }

    public List<TeamDTO> getAll(){

        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(team -> TeamDTO.get(team.getId(), team.getClub(), team.getName(), team.getCoaches(), team.getPlayers(), team.getCategory() )).collect(Collectors.toList());

    }

}
