package com.projet.scootop.scootop.service.domainuser;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Coach;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.model.domainuser.CoachDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.domainuser.CoachRepository;
import com.projet.scootop.scootop.service.UserService;
import com.projet.scootop.scootop.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
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
        userService.updateEntity(coachDTO.user);
        for (Team team: coachDTO.teams
             ) {
            teamRepository.save(team);
        }
        Coach coach=new Coach(coachDTO.user,coachDTO.teams);

        return coachRepository.save(coach);
    }
    public Coach get(Integer id){
        return coachRepository.findById(id).orElse(null);
    }
    public Coach update(CoachDTO coachDTO,Integer id) throws Exception {
        User newUser = userService.updateEntity(coachDTO.user);
        Coach coach =new Coach(newUser,coachDTO.teams);
        coach.id=id;

        return coachRepository.save(coach);
    }
    public List<Coach> getAll(){

        return coachRepository.findAll();
    }
    public String delete(Integer id){
        Coach coach = coachRepository.findById(id).orElse(null);
        if(coach==null){
            return null;
        }
        coachRepository.deleteById(id);

        return "Deleted";
    }

}
