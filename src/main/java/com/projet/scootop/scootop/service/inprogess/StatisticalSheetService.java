package com.projet.scootop.scootop.service.inprogess;

import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.domain.services.Wearable;
import com.projet.scootop.scootop.model.inprogress.StatisticalSheetDTO;
import com.projet.scootop.scootop.model.services.WearableDTO;
import com.projet.scootop.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.scootop.repository.statistical.AssistRepository;
import com.projet.scootop.scootop.repository.statistical.GoalRepository;
import com.projet.scootop.scootop.repository.statistical.ShootRepository;
import com.projet.scootop.scootop.repository.statistical.SkillRepository;
import com.projet.scootop.scootop.repository.statistical.physical.PlayerHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Service
public class StatisticalSheetService {
 @Autowired
    public StatisticalSheetRepository statisticalSheetRepository;
 @Autowired
    public ShootRepository shootRepository;
 @Autowired
    public PlayerHeadRepository playerHeadRepository;
 @Autowired
    public AssistRepository assistRepository;
 @Autowired
    public SkillRepository skillRepository;
 @Autowired
    public GoalRepository goalRepository;
    public StatisticalSheet add(StatisticalSheetDTO statisticalSheetDTO) throws Exception {
        shootRepository.saveAll(statisticalSheetDTO.Shoots);
        playerHeadRepository.saveAll(statisticalSheetDTO.Heads);
        assistRepository.saveAll(statisticalSheetDTO.assists);
        skillRepository.saveAll(statisticalSheetDTO.skills);
        goalRepository.saveAll(statisticalSheetDTO.goals);
        StatisticalSheet statisticalSheet=new StatisticalSheet(statisticalSheetDTO.matchSheet,statisticalSheetDTO.players,statisticalSheetDTO.events,statisticalSheetDTO.ShootIn,statisticalSheetDTO.ShootOut,statisticalSheetDTO.ballplayed,statisticalSheetDTO.balllost,statisticalSheetDTO.ballSuccess,statisticalSheetDTO.Shoots,statisticalSheetDTO.Heads,statisticalSheetDTO.assists,statisticalSheetDTO.skills,statisticalSheetDTO.goals,statisticalSheetDTO.distancekm);
        return statisticalSheetRepository.save(statisticalSheet);

    }
    public StatisticalSheet update(StatisticalSheetDTO statisticalSheetDTO, Integer id) throws Exception {
        shootRepository.saveAll(statisticalSheetDTO.Shoots);
        playerHeadRepository.saveAll(statisticalSheetDTO.Heads);
        assistRepository.saveAll(statisticalSheetDTO.assists);
        skillRepository.saveAll(statisticalSheetDTO.skills);
        goalRepository.saveAll(statisticalSheetDTO.goals);
        StatisticalSheet statisticalSheet=new StatisticalSheet(statisticalSheetDTO.matchSheet,statisticalSheetDTO.players,statisticalSheetDTO.events,statisticalSheetDTO.ShootIn,statisticalSheetDTO.ShootOut,statisticalSheetDTO.ballplayed,statisticalSheetDTO.balllost,statisticalSheetDTO.ballSuccess,statisticalSheetDTO.Shoots,statisticalSheetDTO.Heads,statisticalSheetDTO.assists,statisticalSheetDTO.skills,statisticalSheetDTO.goals,statisticalSheetDTO.distancekm);
        statisticalSheet.id=id;
        return statisticalSheetRepository.save(statisticalSheet);
    }
    public StatisticalSheet get(Integer id){
        return statisticalSheetRepository.findById(id).orElse(null);
    }


    public StatisticalSheetDTO getOneStatSheetByMatchSheet(int matchsheetId){


        StatisticalSheet statisticalSheet = statisticalSheetRepository.findByMatchSheet(matchsheetId);
        if(statisticalSheet==null){
            return null;
        }

        return StatisticalSheetDTO.get(statisticalSheet.id, statisticalSheet.matchSheet, statisticalSheet.players, statisticalSheet.events, statisticalSheet.ShootIn, statisticalSheet.ShootOut,statisticalSheet.ballplayed, statisticalSheet.balllost, statisticalSheet.ballSuccess, statisticalSheet.Shoots, statisticalSheet.Heads, statisticalSheet.assists, statisticalSheet.skills, statisticalSheet.goals, statisticalSheet.distancekm);
    }

    public List<StatisticalSheet> getAll(){
        return statisticalSheetRepository.findAll();
    }
    public ResponseEntity<Integer> delete(Integer id){
        StatisticalSheet statisticalSheet = statisticalSheetRepository.findById(id).orElse(null);
        if(statisticalSheet==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statisticalSheetRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
