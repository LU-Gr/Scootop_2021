package com.projet.scootop.scootop.service.stastistical;

import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.model.statistical.AssistDTO;
import com.projet.scootop.scootop.repository.inprogress.MatchSheetRepository;
import com.projet.scootop.scootop.repository.statistical.AssistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Service
public class AssistService {
   @Autowired
    public AssistRepository assistRepository;
    @Autowired
    public MatchSheetRepository matchSheetRepository;

    public Pass add(AssistDTO assistDTO){
        matchSheetRepository.save(assistDTO.matchSheet);
        Pass assist = new Pass(assistDTO.matchSheet,assistDTO.player,assistDTO.date,assistDTO.typeTouch,assistDTO.decisive,assistDTO.successAssist,assistDTO.longPass);
        return assistRepository.save(assist);

    }
    public Pass get(Integer id){
        return assistRepository.findById(id).orElse(null);
    }
    public Pass update(AssistDTO assistDTO, Integer id){
        matchSheetRepository.save(assistDTO.matchSheet);
        Pass assist = new Pass(assistDTO.matchSheet,assistDTO.player,assistDTO.date,assistDTO.typeTouch,assistDTO.decisive,assistDTO.successAssist,assistDTO.longPass);
        assist.id=id;
        return assistRepository.save(assist);
    }
    public List<Pass> getAll(){
        return assistRepository.findAll();
    }
    public String delete(Integer id){
        assistRepository.deleteById(id);

        return "Deleted";
    }
}
