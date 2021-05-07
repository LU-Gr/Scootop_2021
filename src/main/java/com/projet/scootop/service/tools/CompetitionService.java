package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Competition;
import com.projet.scootop.mappers.tools.CompetitionMapper;
import com.projet.scootop.model.tools.CompetitionDTO;
import com.projet.scootop.repository.tools.CompetitionRepository;

import java.util.List;

@Service
public class CompetitionService {
	
    @Autowired
    private CompetitionRepository competionTypeRepository;
    
    @Autowired
    private CompetitionMapper competitionMapper;
    
    public CompetitionDTO add(CompetitionDTO competionTypeDTO){
        Competition competionType = competitionMapper.mapTo(competionTypeDTO);
        competionTypeRepository.save(competionType);
        return competitionMapper.mapTo(competionType);

    }
    
    public CompetitionDTO get(Long id){
        return competitionMapper.mapTo(competionTypeRepository.findById(id).orElse(null));
    }
    
    public CompetitionDTO update(CompetitionDTO competitionDTO){
    	Competition competition = competitionMapper.mapTo(competitionDTO);
    	competionTypeRepository.save(competition);
        return competitionMapper.mapTo(competition);
    }
    
    public List<CompetitionDTO> getAll(){
        List<Competition> competitions = competionTypeRepository.findAll();
        return competitionMapper.mapTo(competitions);
    }
    	
    
    public String delete(Long id){
        Competition competionType = competionTypeRepository.findById(id).orElse(null);
        if(competionType==null){
            return null;
        }
        competionTypeRepository.deleteById(id);

        return "Deleted";
    }
}
