package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.mappers.tools.MatchMapper;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.repository.tools.MatchRepository;
import com.projet.scootop.repository.tools.SaisonRepository;
import com.projet.scootop.repository.tools.StatisticalSheetRepository;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.domainuser.ScootRepository;

import java.util.List;

@Service
public class MatchService {
	
    @Autowired private MatchRepository matchSheetRepository;
    @Autowired private ScootRepository scootRepository;
    @Autowired private StatisticalSheetRepository statisticalSheetRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private SaisonRepository saisonRepository;
    @Autowired private MatchMapper mapper;

    public MatchDTO add(MatchDTO matchSheetDTO) throws Exception {
    	Match matchSheet = mapper.mapTo(matchSheetDTO);
        scootRepository.saveAll(matchSheet.getScoots());
        statisticalSheetRepository.saveAll(matchSheet.getStatisticalSheetsTeamA());
        statisticalSheetRepository.saveAll(matchSheet.getStatisticalSheetsTeamB());
        teamRepository.save(matchSheet.getTeamA());
        teamRepository.save(matchSheet.getTeamB());
        saisonRepository.save(matchSheet.getSaison());
        matchSheetRepository.save(matchSheet);
        return mapper.mapToDTO(matchSheet);
    }
    
    public MatchDTO update(MatchDTO matchSheetDTO) throws Exception {
    	Match matchSheet = mapper.mapTo(matchSheetDTO);
        scootRepository.saveAll(matchSheet.getScoots());
        statisticalSheetRepository.saveAll(matchSheet.getStatisticalSheetsTeamA());
        statisticalSheetRepository.saveAll(matchSheet.getStatisticalSheetsTeamB());
        teamRepository.save(matchSheet.getTeamA());
        teamRepository.save(matchSheet.getTeamB());
        saisonRepository.save(matchSheet.getSaison());
        matchSheetRepository.save(matchSheet);
        return mapper.mapToDTO(matchSheet);
    }
    
    public MatchDTO get(Long id){
    	Match matchSheet = matchSheetRepository.findById(id).orElse(null);
        return mapper.mapToDTO(matchSheet);
    }
    
    public List<MatchDTO> getAll(){
    	List<Match> matchSheets = matchSheetRepository.findAll();
    	return mapper.mapToDTO(matchSheets);
    }
    
    public ResponseEntity<Integer> delete(Long id){
        Match matchSheet = matchSheetRepository.findById(id).orElse(null);
        if(matchSheet==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        matchSheetRepository.deleteById(id);
        return new ResponseEntity<>(id.intValue(), HttpStatus.OK);
    }

}
