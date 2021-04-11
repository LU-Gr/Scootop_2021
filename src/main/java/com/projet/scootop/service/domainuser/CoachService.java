package com.projet.scootop.service.domainuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainuser.Coach;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.model.domainuser.CoachDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainuser.CoachRepository;
import com.projet.scootop.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoachService {

    @Autowired
    public CoachRepository coachRepository;
    public UserService userService;
    public TeamRepository teamRepository;

    public CoachService(CoachRepository coachRepository, UserService userService,TeamRepository teamRepository) {
        this.coachRepository = coachRepository;
        this.userService = userService;
        this.teamRepository =teamRepository;
    }

    public Coach add(CoachDTO coachDTO) throws Exception {
        userService.updateEntity(coachDTO.getUser());
        Coach coach = new Coach(coachDTO.getUser(),new ArrayList<>());
        return coachRepository.save(coach);
    }
    
    public Coach get(Long id){
        return coachRepository.findById(id).orElse(null);
    }
    
    public Coach update(CoachDTO coachDTO,Long id) throws Exception {
        User newUser = userService.updateEntity(coachDTO.getUser());
        Coach coach = new Coach(newUser, coachDTO.getTeams());
        coach.setId(id);
        return coachRepository.save(coach);
    }
    
    public List<Coach> getAll(){

        return coachRepository.findAll();
    }
    public String delete(Long id){
        Coach coach = coachRepository.findById(id).orElse(null);
        if(coach==null){
            return null;
        }
        coachRepository.deleteById(id);

        return "Deleted";
    }

}
