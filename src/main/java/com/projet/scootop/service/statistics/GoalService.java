package com.projet.scootop.service.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistics.Goal;
import com.projet.scootop.mappers.statistics.GoalMapper;
import com.projet.scootop.model.statistics.GoalDTO;
import com.projet.scootop.repository.statistics.GoalRepository;

import java.util.List;

@Service
public class GoalService {
	
    @Autowired private GoalRepository goalRepository;
    @Autowired private GoalMapper mapper;
    
    
    public GoalDTO add(GoalDTO goalDTO){
        Goal goal = mapper.mapTo(goalDTO);
        goalRepository.save(goal);
        return mapper.mapToDTO(goal);
    }
    
    public GoalDTO get(Long id){
    	Goal goal = goalRepository.findById(id).orElse(null);
        return mapper.mapToDTO(goal);
    }
    
    public List<GoalDTO> getAll(){
    	List<Goal> goals = goalRepository.findAll();
        return mapper.mapToDTO(goals);
    }
    
    public String delete(Long id){
        goalRepository.deleteById(id);
        return "Deleted";
    }
}
