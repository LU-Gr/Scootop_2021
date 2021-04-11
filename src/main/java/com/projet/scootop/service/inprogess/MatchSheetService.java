package com.projet.scootop.service.inprogess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.services.Wearable;
import com.projet.scootop.model.inprogress.MatchSheetDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainetools.SaisonRepository;
import com.projet.scootop.repository.domainuser.ScootRepository;
import com.projet.scootop.repository.inprogress.MatchSheetRepository;
import com.projet.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.repository.services.WearableRepository;

import java.util.List;

@Service
public class MatchSheetService {
	
    @Autowired
    public MatchSheetRepository matchSheetRepository;
    @Autowired
    public ScootRepository scootRepository;
    @Autowired
    public StatisticalSheetRepository statisticalSheetRepository;
    @Autowired
    public TeamRepository teamRepository;
    @Autowired
    public SaisonRepository saisonRepository;
    @Autowired
    public WearableRepository wearableRepository;

    public MatchSheet add(MatchSheetDTO matchSheetDTO) throws Exception {
        scootRepository.saveAll(matchSheetDTO.matchScoots);
        statisticalSheetRepository.saveAll(matchSheetDTO.statisticalSheets);
        teamRepository.saveAll(matchSheetDTO.team);
        saisonRepository.save(matchSheetDTO.saison);
        MatchSheet matchSheet=new MatchSheet(matchSheetDTO.event,matchSheetDTO.team,matchSheetDTO.statisticalSheets,matchSheetDTO.stade,matchSheetDTO.matchScoots, matchSheetDTO.wearables,matchSheetDTO.saison,matchSheetDTO.competitionType);
        return matchSheetRepository.save(matchSheet);
    }
    
    public MatchSheet update(MatchSheetDTO matchSheetDTO, Long id) throws Exception {
        scootRepository.saveAll(matchSheetDTO.matchScoots);
        statisticalSheetRepository.saveAll(matchSheetDTO.statisticalSheets);
        teamRepository.saveAll(matchSheetDTO.team);
        saisonRepository.save(matchSheetDTO.saison);
        MatchSheet matchSheet=new MatchSheet(matchSheetDTO.event,matchSheetDTO.team,matchSheetDTO.statisticalSheets,matchSheetDTO.stade,matchSheetDTO.matchScoots,matchSheetDTO.wearables,matchSheetDTO.saison,matchSheetDTO.competitionType);
        matchSheet.id=id;
        return matchSheetRepository.save(matchSheet);
    }
    
    public MatchSheet get(Long id){
        return matchSheetRepository.findById(id).orElse(null);
    }
    
    public List<MatchSheet> getAll(){
        return matchSheetRepository.findAll();
    }
    
    public List<Wearable> getAllWearable(Integer id){
        return wearableRepository.findAll();
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