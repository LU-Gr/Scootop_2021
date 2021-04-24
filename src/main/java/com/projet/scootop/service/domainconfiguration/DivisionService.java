package com.projet.scootop.service.domainconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainconfiguration.Division;
import com.projet.scootop.domain.domainconfiguration.League;
import com.projet.scootop.mappers.domainconfiguration.DivisionMapper;
import com.projet.scootop.model.domainconfiguration.DivisionDTO;
import com.projet.scootop.repository.domainconfiguration.DivisionRepository;
import com.projet.scootop.repository.domainconfiguration.LeagueRepository;

import java.util.List;

@Service
public class DivisionService {
	
    @Autowired
    public DivisionRepository divisionRepository;
    
    @Autowired
    public LeagueRepository leagueRepository;
    
    @Autowired
    private DivisionMapper divisionMapper;
    
    public DivisionDTO add(DivisionDTO divisionDTO, Long leagueId){
        League leagues = leagueRepository.findById(leagueId).orElse(null);
        Division newDivision = divisionMapper.mapTo(divisionDTO);
        leagues.getDivisions().add(newDivision);
        divisionRepository.save(newDivision);
        return divisionDTO;
    }
    
    public DivisionDTO get(Long id){

        Division division = divisionRepository.findById(id).orElse(null);
        if(division==null){
            return null;
        }
        return divisionMapper.mapTo(division);
    }
    
    public List<DivisionDTO> getAll(){
        List<Division> divisions = divisionRepository.findAll();
        return divisionMapper.mapTo(divisions);
    }
    
    public String delete(Long id){
        Division division = divisionRepository.findById(id).orElse(null);
        if(division==null){
            return null;
        }
        divisionRepository.deleteById(id);
        return "Deleted";
    }

}
