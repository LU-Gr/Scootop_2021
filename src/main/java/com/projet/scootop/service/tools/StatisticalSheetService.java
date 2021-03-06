package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.mappers.tools.StatisticalSheetMapper;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.repository.statistics.ActionRepository;
import com.projet.scootop.repository.statistics.GoalRepository;
import com.projet.scootop.repository.statistics.PassRepository;
import com.projet.scootop.repository.statistics.ShootRepository;
import com.projet.scootop.repository.tools.StatisticalSheetRepository;

import java.util.List;

@Service
public class StatisticalSheetService {
	
	@Autowired private StatisticalSheetRepository statisticalSheetRepository;
	@Autowired private ShootRepository shootRepository;
	@Autowired private PassRepository passRepository;
	@Autowired private ActionRepository skillRepository;
	@Autowired private GoalRepository goalRepository;
	@Autowired private StatisticalSheetMapper mapper;
	
	
    public StatisticalSheetDTO add(StatisticalSheetDTO statisticalSheetDTO){
    	StatisticalSheet statisticalSheet = mapper.mapTo(statisticalSheetDTO);
        //shootRepository.saveAll(statisticalSheet.getShoots());
        //passRepository.saveAll(statisticalSheet.getPasses());
        //skillRepository.saveAll(statisticalSheet.getActions());
        //goalRepository.saveAll(statisticalSheet.getGoals());
        statisticalSheetRepository.save(statisticalSheet);
        return mapper.mapToDTO(statisticalSheet);
    }
    
    public StatisticalSheetDTO update(StatisticalSheetDTO statisticalSheetDTO){
    	StatisticalSheet statisticalSheet = mapper.mapTo(statisticalSheetDTO);
        //shootRepository.saveAll(statisticalSheet.getShoots());
        //passRepository.saveAll(statisticalSheet.getPasses());
        //skillRepository.saveAll(statisticalSheet.getActions());
        //goalRepository.saveAll(statisticalSheet.getGoals());
        statisticalSheetRepository.save(statisticalSheet);
        return mapper.mapToDTO(statisticalSheet);
    }
    
    public StatisticalSheetDTO get(Long id){
    	StatisticalSheet statisticalSheet = statisticalSheetRepository.findById(id).orElse(null);
    	return mapper.mapToDTO(statisticalSheet);
    }


    public StatisticalSheetDTO getOneStatSheetByMatchSheet(Long matchsheetId){
        StatisticalSheet statisticalSheet = statisticalSheetRepository.findByMatch(matchsheetId);
        if(statisticalSheet==null){
            return null;
        }
        return mapper.mapToDTO(statisticalSheet);
    }
    
    public StatisticalSheetDTO getSheetByPlayerAndEvent(Long playerId, Long eventId){
    	StatisticalSheet sheet = statisticalSheetRepository.findByPlayerIdAndEventId(playerId, eventId);
    	return mapper.mapToDTO(sheet);
    }

    public List<StatisticalSheetDTO> getAll(){
    	List<StatisticalSheet> statisticalSheets = statisticalSheetRepository.findAll();
    	return mapper.mapToDTO(statisticalSheets);
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
