package com.projet.scootop.scootop.service.services;

import com.projet.scootop.scootop.domain.domaintools.CompetitionType;
import com.projet.scootop.scootop.domain.services.UserResume;
import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.domain.stastistical.Goal;
import com.projet.scootop.scootop.model.services.UserResumeDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.domainetools.CompetitionTypeRepository;
import com.projet.scootop.scootop.repository.domainetools.SaisonRepository;
import com.projet.scootop.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.scootop.repository.services.UserResumeRepository;
import com.projet.scootop.scootop.repository.statistical.AssistRepository;
import com.projet.scootop.scootop.repository.statistical.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserResumeService {
    @Autowired
    public UserResumeRepository userResumeRepository;

    @Autowired
    public PlayerRepository playerRepository;

    @Autowired
    public CompetitionTypeRepository competitionTypeRepository;

    @Autowired
    public GoalRepository goalRepository;

    @Autowired
    public AssistRepository assistRepository;

    @Autowired
    public StatisticalSheetRepository statisticalsheetRepository;

    @Autowired
    public TeamRepository teamsRepository;

    @Autowired
    public SaisonRepository saisonRepository;

    public UserResumeDTO addUserResume(UserResumeDTO userResumeDTO) {

        playerRepository.save(userResumeDTO.player);
        competitionTypeRepository.save(userResumeDTO.competitionType);
        goalRepository.saveAll(userResumeDTO.goals);
        assistRepository.saveAll(userResumeDTO.assists);
        statisticalsheetRepository.saveAll(userResumeDTO.statisticalSheets);
        teamsRepository.saveAll(userResumeDTO.teams);
        saisonRepository.saveAll(userResumeDTO.saisons);

        UserResume userResume = new UserResume(userResumeDTO.player, userResumeDTO.competitionType, userResumeDTO.goals, userResumeDTO.assists,userResumeDTO.statisticalSheets, userResumeDTO.distance_traveled, userResumeDTO.teams,userResumeDTO.saisons, userResumeDTO.ballPlayed, userResumeDTO.ballLost, userResumeDTO.defensiveSkills, userResumeDTO.offensiveSkills);
        userResumeRepository.save(userResume);
        return userResumeDTO;
    }

    public UserResumeDTO get(Integer id){

        UserResume userResume = userResumeRepository.findById(id).orElse(null);

        if(userResume==null){
            return null;
        }

        return UserResumeDTO.get(userResume.id, userResume.player, userResume.competitionType, userResume.goals, userResume.assists,userResume.statisticalSheets, userResume.distance_traveled, userResume.teams,userResume.saisons, userResume.ballPlayed, userResume.ballLost, userResume.OffensiveSkills, userResume.defensiveSkills);
    }

    public List<UserResumeDTO> getAll(){

        List<UserResume> userResumes = userResumeRepository.findAll();
        return userResumes.stream().map(userResume -> UserResumeDTO.get(userResume.id, userResume.player, userResume.competitionType, userResume.goals, userResume.assists,userResume.statisticalSheets, userResume.distance_traveled, userResume.teams,userResume.saisons, userResume.ballPlayed, userResume.ballLost, userResume.OffensiveSkills, userResume.defensiveSkills)).collect(Collectors.toList());
    }
}
