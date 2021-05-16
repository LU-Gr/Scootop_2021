package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.Division;
import com.projet.scootop.domain.configuration.League;
import com.projet.scootop.mappers.configuration.DivisionMapper;
import com.projet.scootop.model.configuration.DivisionDTO;
import com.projet.scootop.repository.configuration.DivisionRepository;
import com.projet.scootop.repository.configuration.LeagueRepository;

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
        return divisionMapper.mapToDTO(division);
    }
    
    public List<DivisionDTO> getAll(){
        List<Division> divisions = divisionRepository.findAll();
        return divisionMapper.mapToDTO(divisions);
    }
    
    public String delete(Long id){
        Division division = divisionRepository.findById(id).orElse(null);
        if(division==null){
            return null;
        }
        divisionRepository.deleteById(id);
        return "Deleted";
    }

	public DivisionDTO update(DivisionDTO body) {
		// TODO Auto-generated method stub
		return null;
	}

}
