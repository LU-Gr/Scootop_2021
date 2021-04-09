package com.projet.scootop.scootop.service.stastistical;

import com.projet.scootop.scootop.domain.statistical.Action;
import com.projet.scootop.scootop.model.statistical.ActionDTO;
import com.projet.scootop.scootop.repository.statistical.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {
	
    @Autowired
    public ActionRepository skillRepository;
    
    public ActionDTO add(ActionDTO actionDTO){
        Action action = new Action(actionDTO.id,actionDTO.matchSheet,actionDTO.player,actionDTO.isDefensive,actionDTO.successSkill,actionDTO.isLong);
        skillRepository.save(action);
        return  actionDTO;
    }
    
    public ActionDTO get(Long id){
        return null;
    }
    
    public List<ActionDTO> getAll(){
        return null;
    }
    
    public String delete(Long id){
        skillRepository.deleteById(id);
        return "Deleted";
    }

}
