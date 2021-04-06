package com.projet.scootop.scootop.service.stastistical;

import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.model.statistical.PassDTO;
import com.projet.scootop.scootop.repository.inprogress.MatchSheetRepository;
import com.projet.scootop.scootop.repository.statistical.PassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassService {
	
	@Autowired
    public PassRepository assistRepository;
	
    @Autowired
    public MatchSheetRepository matchSheetRepository;

    public Pass add(PassDTO assistDTO){
        matchSheetRepository.save(assistDTO.matchSheet);
        Pass assist = new Pass(assistDTO.matchSheet,assistDTO.player,assistDTO.date,assistDTO.typeTouch,assistDTO.decisive,assistDTO.successAssist,assistDTO.longPass);
        return assistRepository.save(assist);
    }
    
    public Pass get(Long id){
        return assistRepository.findById(id).orElse(null);
    }
    
    public Pass update(PassDTO assistDTO, Long id){
        matchSheetRepository.save(assistDTO.matchSheet);
        Pass assist = new Pass(assistDTO.matchSheet,assistDTO.player,assistDTO.date,assistDTO.typeTouch,assistDTO.decisive,assistDTO.successAssist,assistDTO.longPass);
        assist.id=id;
        return assistRepository.save(assist);
    }
    
    public List<Pass> getAll(){
        return assistRepository.findAll();
    }
    
    public String delete(Long id){
        assistRepository.deleteById(id);
        return "Deleted";
    }
}
