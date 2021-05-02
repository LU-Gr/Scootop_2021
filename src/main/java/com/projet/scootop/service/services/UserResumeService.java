package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.UserResume;
import com.projet.scootop.mappers.services.UserResumeMapper;
import com.projet.scootop.model.services.UserResumeDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainetools.CompetitionRepository;
import com.projet.scootop.repository.domainetools.SaisonRepository;
import com.projet.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.repository.services.UserResumeRepository;
import java.util.List;

@Service
public class UserResumeService {
	
    @Autowired private UserResumeRepository userResumeRepository;
    @Autowired private PlayerRepository playerRepository;
    @Autowired private CompetitionRepository competitionTypeRepository;
    @Autowired private StatisticalSheetRepository statisticalsheetRepository;
    @Autowired private SaisonRepository saisonRepository;
    @Autowired private UserResumeMapper mapper;

    public UserResumeDTO addUserResume(UserResumeDTO userResumeDTO) {
    	UserResume userResume = mapper.mapTo(userResumeDTO);
        playerRepository.save(userResume.getPlayer());
        competitionTypeRepository.save(userResume.getCompetitionType());
        statisticalsheetRepository.saveAll(userResume.getStatisticalSheets());
        saisonRepository.saveAll(userResume.getSaisons());
        userResumeRepository.save(userResume);
        return mapper.mapTo(userResume);
    }

    public UserResumeDTO get(Long id){
        UserResume userResume = userResumeRepository.findById(id).orElse(null);
        if(userResume==null){
            return null;
        }
        return mapper.mapTo(userResume);
    }

    public List<UserResumeDTO> getAll(){
        List<UserResume> userResumes = userResumeRepository.findAll();
        return mapper.mapTo(userResumes);
    }
}
