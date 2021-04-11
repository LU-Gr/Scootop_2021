package com.projet.scootop.service.statistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.Goal;
import com.projet.scootop.mappers.statistical.GoalMapper;
import com.projet.scootop.model.statistical.GoalDTO;
import com.projet.scootop.repository.statistical.GoalRepository;
import java.util.List;

@Service
public class GoalService {
	
    @Autowired private GoalRepository goalRepository;
    @Autowired private GoalMapper mapper;
    
    
    public GoalDTO add(GoalDTO goalDTO){
        Goal goal = mapper.mapTo(goalDTO);
        goalRepository.save(goal);
        return mapper.mapTo(goal);
    }
    
    public GoalDTO get(Long id){
    	Goal goal = goalRepository.findById(id).orElse(null);
        return mapper.mapTo(goal);
    }
    
    public List<GoalDTO> getAll(){
    	List<Goal> goals = goalRepository.findAll();
        return mapper.mapTo(goals);
    }
    
    public String delete(Long id){
        goalRepository.deleteById(id);
        return "Deleted";
    }
}
