package com.projet.scootop.service.inprogess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.model.inprogress.StatisticalSheetDTO;
import com.projet.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.repository.statistical.ActionRepository;
import com.projet.scootop.repository.statistical.GoalRepository;
import com.projet.scootop.repository.statistical.PassRepository;
import com.projet.scootop.repository.statistical.ShootRepository;
import com.projet.scootop.repository.statistical.physical.PlayerHeadRepository;

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
    public PassRepository assistRepository;
	@Autowired
    public ActionRepository skillRepository;
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
    
    public StatisticalSheet update(StatisticalSheetDTO statisticalSheetDTO, Long id) throws Exception {
        shootRepository.saveAll(statisticalSheetDTO.Shoots);
        playerHeadRepository.saveAll(statisticalSheetDTO.Heads);
        assistRepository.saveAll(statisticalSheetDTO.assists);
        skillRepository.saveAll(statisticalSheetDTO.skills);
        goalRepository.saveAll(statisticalSheetDTO.goals);
        StatisticalSheet statisticalSheet=new StatisticalSheet(statisticalSheetDTO.matchSheet,statisticalSheetDTO.players,statisticalSheetDTO.events,statisticalSheetDTO.ShootIn,statisticalSheetDTO.ShootOut,statisticalSheetDTO.ballplayed,statisticalSheetDTO.balllost,statisticalSheetDTO.ballSuccess,statisticalSheetDTO.Shoots,statisticalSheetDTO.Heads,statisticalSheetDTO.assists,statisticalSheetDTO.skills,statisticalSheetDTO.goals,statisticalSheetDTO.distancekm);
        statisticalSheet.id=id;
        return statisticalSheetRepository.save(statisticalSheet);
    }
    
    public StatisticalSheet get(Long id){
        return statisticalSheetRepository.findById(id).orElse(null);
    }


    public StatisticalSheetDTO getOneStatSheetByMatchSheet(Long matchsheetId){
        StatisticalSheet statisticalSheet = statisticalSheetRepository.findByMatchSheet(matchsheetId);
        if(statisticalSheet==null){
            return null;
        }
        return StatisticalSheetDTO.get(statisticalSheet.id, statisticalSheet.matchSheet, statisticalSheet.players, statisticalSheet.events, statisticalSheet.ShootIn, statisticalSheet.ShootOut,statisticalSheet.ballplayed, statisticalSheet.balllost, statisticalSheet.ballSuccess, statisticalSheet.Shoots, statisticalSheet.Heads, statisticalSheet.passes, statisticalSheet.skills, statisticalSheet.goals, statisticalSheet.distancekm);
    }

    public List<StatisticalSheet> getAll(){
        return statisticalSheetRepository.findAll();
    }
    
    public ResponseEntity<Integer> delete(Long id){
        StatisticalSheet statisticalSheet = statisticalSheetRepository.findById(id).orElse(null);
        if(statisticalSheet==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statisticalSheetRepository.deleteById(id);
        return new ResponseEntity<>(id.intValue(), HttpStatus.OK);
    }

}
