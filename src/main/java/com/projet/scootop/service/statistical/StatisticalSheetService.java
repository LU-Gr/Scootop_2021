package com.projet.scootop.service.statistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.StatisticalSheet;
import com.projet.scootop.mappers.statistical.StatisticalSheetMapper;
import com.projet.scootop.model.statistical.StatisticalSheetDTO;
import com.projet.scootop.repository.statistical.ActionRepository;
import com.projet.scootop.repository.statistical.GoalRepository;
import com.projet.scootop.repository.statistical.PassRepository;
import com.projet.scootop.repository.statistical.ShootRepository;
import com.projet.scootop.repository.statistical.StatisticalSheetRepository;
import com.projet.scootop.repository.statistical.physical.PlayerHeadRepository;

import java.util.List;

@Service
public class StatisticalSheetService {
	
	@Autowired private StatisticalSheetRepository statisticalSheetRepository;
	@Autowired private ShootRepository shootRepository;
	@Autowired private PlayerHeadRepository playerHeadRepository;
	@Autowired private PassRepository passRepository;
	@Autowired private ActionRepository skillRepository;
	@Autowired private GoalRepository goalRepository;
	@Autowired private StatisticalSheetMapper mapper;
	
	public StatisticalSheetDTO getSheetByPlayerId(Long playerId) {
		
		return null;
		
	}
	
    public StatisticalSheetDTO add(StatisticalSheetDTO statisticalSheetDTO) throws Exception {
    	StatisticalSheet statisticalSheet = mapper.mapTo(statisticalSheetDTO);
        shootRepository.saveAll(statisticalSheet.getShoots());
        playerHeadRepository.saveAll(statisticalSheet.getHeads());
        passRepository.saveAll(statisticalSheet.getPasses());
        skillRepository.saveAll(statisticalSheet.getActions());
        goalRepository.saveAll(statisticalSheet.getGoals());
        statisticalSheetRepository.save(statisticalSheet);
        return mapper.mapTo(statisticalSheet);
    }
    
    public StatisticalSheetDTO update(StatisticalSheetDTO statisticalSheetDTO) throws Exception {
    	StatisticalSheet statisticalSheet = mapper.mapTo(statisticalSheetDTO);
        shootRepository.saveAll(statisticalSheet.getShoots());
        playerHeadRepository.saveAll(statisticalSheet.getHeads());
        passRepository.saveAll(statisticalSheet.getPasses());
        skillRepository.saveAll(statisticalSheet.getActions());
        goalRepository.saveAll(statisticalSheet.getGoals());
        statisticalSheetRepository.save(statisticalSheet);
        return mapper.mapTo(statisticalSheet);
    }
    
    public StatisticalSheetDTO get(Long id){
    	StatisticalSheet statisticalSheet = statisticalSheetRepository.findById(id).orElse(null);
    	return mapper.mapTo(statisticalSheet);
    }


    public StatisticalSheetDTO getOneStatSheetByMatchSheet(Long matchsheetId){
        StatisticalSheet statisticalSheet = statisticalSheetRepository.findByMatchSheet(matchsheetId);
        if(statisticalSheet==null){
            return null;
        }
        return mapper.mapTo(statisticalSheet);
    }

    public List<StatisticalSheetDTO> getAll(){
    	List<StatisticalSheet> statisticalSheets = statisticalSheetRepository.findAll();
    	return mapper.mapTo(statisticalSheets);
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