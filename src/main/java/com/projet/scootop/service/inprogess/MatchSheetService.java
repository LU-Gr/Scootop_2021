package com.projet.scootop.service.inprogess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.mappers.inprogress.MatchSheetMapper;
import com.projet.scootop.model.inprogress.MatchSheetDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainetools.SaisonRepository;
import com.projet.scootop.repository.domainuser.ScootRepository;
import com.projet.scootop.repository.inprogress.MatchSheetRepository;
import com.projet.scootop.repository.inprogress.StatisticalSheetRepository;
import java.util.List;

@Service
public class MatchSheetService {
	
    @Autowired private MatchSheetRepository matchSheetRepository;
    @Autowired private ScootRepository scootRepository;
    @Autowired private StatisticalSheetRepository statisticalSheetRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private SaisonRepository saisonRepository;
    @Autowired private MatchSheetMapper mapper;

    public MatchSheetDTO add(MatchSheetDTO matchSheetDTO) throws Exception {
    	MatchSheet matchSheet = mapper.mapTo(matchSheetDTO);
        scootRepository.saveAll(matchSheet.getMatchScoots());
        statisticalSheetRepository.saveAll(matchSheet.getStatisticalSheets());
        teamRepository.save(matchSheet.getTeam1());
        teamRepository.save(matchSheet.getTeam2());
        saisonRepository.save(matchSheet.getSaison());
        matchSheetRepository.save(matchSheet);
        return mapper.mapTo(matchSheet);
    }
    
    public MatchSheetDTO update(MatchSheetDTO matchSheetDTO) throws Exception {
    	MatchSheet matchSheet = mapper.mapTo(matchSheetDTO);
        scootRepository.saveAll(matchSheet.getMatchScoots());
        statisticalSheetRepository.saveAll(matchSheet.getStatisticalSheets());
        teamRepository.save(matchSheet.getTeam1());
        teamRepository.save(matchSheet.getTeam2());
        saisonRepository.save(matchSheet.getSaison());
        matchSheetRepository.save(matchSheet);
        return mapper.mapTo(matchSheet);
    }
    
    public MatchSheetDTO get(Long id){
    	MatchSheet matchSheet = matchSheetRepository.findById(id).orElse(null);
        return mapper.mapTo(matchSheet);
    }
    
    public List<MatchSheetDTO> getAll(){
    	List<MatchSheet> matchSheets = matchSheetRepository.findAll();
    	return mapper.mapTo(matchSheets);
    }
    
    public ResponseEntity<Integer> delete(Long id){
        MatchSheet matchSheet = matchSheetRepository.findById(id).orElse(null);
        if(matchSheet==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        matchSheetRepository.deleteById(id);
        return new ResponseEntity<>(id.intValue(), HttpStatus.OK);
    }

}
