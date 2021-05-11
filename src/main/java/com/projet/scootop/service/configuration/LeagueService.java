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
    
    @Autowired private LeagueMapper lMapper;

    public LeagueDTO add(LeagueDTO leagueDTO){
        List<DivisionDTO> divisionsDTOS = leagueDTO.getDivisions();
        ArrayList<Division> divisions =  new ArrayList<>();
        League newLeague = new League(leagueDTO.getName());
        League league=leagueRepository.save(newLeague);
        for (DivisionDTO divisionDTO: divisionsDTOS) {
            League league1=leagueRepository.findById(league.getId()).orElse(null);
            Division newDivision = new Division(divisionDTO.getName());
            league1.getDivisions().add(newDivision);
            divisionsRepository.save(newDivision);
            //divisionsService.add(divisionDTO,league.id);
            //Divisions newDivision = new Divisions(divisionDTO.name);

            //league.divisions.add(newDivision);
            //divisionsRepository.save(newDivision);

        }
        return leagueDTO;
    }
    
    public LeagueDTO get(Long id){

        League league = leagueRepository.findById(id).orElse(null);
        if(league==null){
            return null;
        }
        return lMapper.mapToDTO(league);
        
    }
    
    public List<LeagueDTO> getAll(){
        List<League> leagues = leagueRepository.findAll();
        return lMapper.mapToDTO(leagues); 
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
}
