package com.projet.scootop.scootop.service.inprogess;

import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.domain.services.Wearable;
import com.projet.scootop.scootop.model.inprogress.MatchSheetDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.domainetools.SaisonRepository;
import com.projet.scootop.scootop.repository.domainuser.ScootRepository;
import com.projet.scootop.scootop.repository.inprogress.MatchSheetRepository;
import com.projet.scootop.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.scootop.repository.services.WearableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
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
    public MatchSheet update(MatchSheetDTO matchSheetDTO, Integer id) throws Exception {
        scootRepository.saveAll(matchSheetDTO.matchScoots);
        statisticalSheetRepository.saveAll(matchSheetDTO.statisticalSheets);
        teamRepository.saveAll(matchSheetDTO.team);
        saisonRepository.save(matchSheetDTO.saison);
        MatchSheet matchSheet=new MatchSheet(matchSheetDTO.event,matchSheetDTO.team,matchSheetDTO.statisticalSheets,matchSheetDTO.stade,matchSheetDTO.matchScoots,matchSheetDTO.wearables,matchSheetDTO.saison,matchSheetDTO.competitionType);
        matchSheet.id=id;
        return matchSheetRepository.save(matchSheet);
    }
    public MatchSheet get(Integer id){
        return matchSheetRepository.findById(id).orElse(null);
    }
    public List<MatchSheet> getAll(){
        return matchSheetRepository.findAll();
    }
    public List<Wearable> getWearableAll(Integer id){

        return wearableRepository.findAll();
    }
    public ResponseEntity<Integer> delete(Integer id){
        MatchSheet matchSheet = matchSheetRepository.findById(id).orElse(null);
        if(matchSheet==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        matchSheetRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
