package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.Division;
import com.projet.scootop.domain.configuration.League;
import com.projet.scootop.mappers.configuration.LeagueMapper;
import com.projet.scootop.model.configuration.DivisionDTO;
import com.projet.scootop.model.configuration.LeagueDTO;
import com.projet.scootop.repository.configuration.DivisionRepository;
import com.projet.scootop.repository.configuration.LeagueRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueService {
	
    @Autowired private LeagueRepository leagueRepository;
    @Autowired private DivisionRepository divisionsRepository;
    @Autowired private LeagueMapper mapper;

    public LeagueDTO add(LeagueDTO leagueDTO){
    	League league = mapper.mapTo(leagueDTO);
    	divisionsRepository.saveAll(league.getDivisions());
        leagueRepository.save(league); 
        return mapper.mapToDTO(league);
    }
    
    public LeagueDTO get(Long id){

        League league = leagueRepository.findById(id).orElse(null);
        if(league==null){
            return null;
        }
        return mapper.mapToDTO(league);
        
    }
    
    public List<LeagueDTO> getAll(){
        List<League> leagues = leagueRepository.findAll();
        return mapper.mapToDTO(leagues); 
    }
    
    
    public String delete(Long id){
        League league = leagueRepository.findById(id).orElse(null);
        if(league==null){
            return null;
        }
        //System.out.println(stade.contact.toString());
        //contactRepository.delete(stade.contact);

        leagueRepository.deleteById(id);

        return "Deleted";
    }

	public LeagueDTO update(LeagueDTO leagueDTO) {
		League league = mapper.mapTo(leagueDTO);
    	divisionsRepository.saveAll(league.getDivisions());
        leagueRepository.save(league); 
        return mapper.mapToDTO(league);
	}
}
