package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.mappers.tools.TeamMapper;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.repository.configuration.CategoryRepository;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.domain.CoachRepository;
import com.projet.scootop.repository.user.domain.PlayerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
	
    @Autowired private TeamRepository teamRepository;
    @Autowired private PlayerRepository playerRepository;
    @Autowired private CoachRepository coachRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private TeamMapper mapper;
    
    public TeamDTO add(TeamDTO teamDTO){
    	
    	Team team = mapper.mapTo(teamDTO);
        teamRepository.save(team);
        return mapper.mapToDTO(team);

    }
    public TeamDTO update(TeamDTO teamDTO){
    	Team team = mapper.mapTo(teamDTO);
        teamRepository.save(team);
        return mapper.mapToDTO(team);

    }

    public TeamDTO get(Long id){


        Team team = teamRepository.findById(id).orElse(null);
        if(team==null){
            return null;
        }
        return mapper.mapToDTO(team);
        
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
        return mapper.mapToDTO(teams);
    }

}
