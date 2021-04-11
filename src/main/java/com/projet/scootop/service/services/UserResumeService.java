package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.UserResume;
import com.projet.scootop.model.services.UserResumeDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainetools.CompetitionRepository;
import com.projet.scootop.repository.domainetools.SaisonRepository;
import com.projet.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.repository.services.UserResumeRepository;
import com.projet.scootop.repository.statistical.GoalRepository;
import com.projet.scootop.repository.statistical.PassRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserResumeService {
    @Autowired
    public UserResumeRepository userResumeRepository;

    @Autowired
    public PlayerRepository playerRepository;

    @Autowired
    public CompetitionRepository competitionTypeRepository;

    @Autowired
    public GoalRepository goalRepository;

    @Autowired
    public PassRepository assistRepository;

    @Autowired
    public StatisticalSheetRepository statisticalsheetRepository;

    @Autowired
    public TeamRepository teamsRepository;

    @Autowired
    public SaisonRepository saisonRepository;

    public UserResumeDTO addUserResume(UserResumeDTO userResumeDTO) {

        playerRepository.save(userResumeDTO.player);
        competitionTypeRepository.save(userResumeDTO.competitionType);
        statisticalsheetRepository.saveAll(userResumeDTO.statisticalSheets);
        teamsRepository.saveAll(userResumeDTO.teams);
        saisonRepository.saveAll(userResumeDTO.saisons);

        UserResume userResume = new UserResume(userResumeDTO.player, userResumeDTO.competitionType, userResumeDTO.statisticalSheets, userResumeDTO.teams,userResumeDTO.saisons, userResumeDTO.defensiveSkills, userResumeDTO.offensiveSkills);
        userResumeRepository.save(userResume);
        return userResumeDTO;
    }

    public UserResumeDTO get(Long id){

        UserResume userResume = userResumeRepository.findById(id).orElse(null);

        if(userResume==null){
            return null;
        }

        return UserResumeDTO.get(userResume.id, userResume.player, userResume.competitionType, userResume.statisticalSheets, userResume.teams,userResume.saisons, userResume.OffensiveSkills, userResume.defensiveSkills);
    }

    public List<UserResumeDTO> getAll(){

        List<UserResume> userResumes = userResumeRepository.findAll();
        return userResumes.stream().map(userResume -> UserResumeDTO.get(userResume.id, userResume.player, userResume.competitionType, userResume.statisticalSheets, userResume.teams,userResume.saisons, userResume.OffensiveSkills, userResume.defensiveSkills)).collect(Collectors.toList());
    }
}