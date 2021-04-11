package com.projet.scootop.service.stastistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.Goal;
import com.projet.scootop.model.statistical.GoalDTO;
import com.projet.scootop.repository.domainconfiguration.ClubRepository;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.statistical.GoalRepository;
import com.projet.scootop.repository.statistical.ShootRepository;

import java.util.List;

@Service
public class GoalService {
    @Autowired
    public GoalRepository goalRepository;
    @Autowired
    public ClubRepository clubRepository;
    @Autowired
    public TeamRepository teamRepository;
    @Autowired
    public ShootRepository shootRepository;
    public Goal add(GoalDTO goalDTO){
        Goal goal = new Goal(goalDTO.date,goalDTO.shoot,goalDTO.tag,goalDTO.distance,goalDTO.rating);
        return goalRepository.save(goal);


    }
    public Goal get(Long id){
        return goalRepository.findById(id).orElse(null);
    }
    public List<Goal> getAll(){
        return goalRepository.findAll();
    }
    public String delete(Long id){

        goalRepository.deleteById(id);

        return "Deleted";
    }
}
