package com.projet.scootop.service.statistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.Action;
import com.projet.scootop.mappers.statistical.ActionMapper;
import com.projet.scootop.model.statistical.ActionDTO;
import com.projet.scootop.repository.statistical.ActionRepository;

import java.util.List;

@Service
public class ActionService {
	
    @Autowired private ActionRepository actionRepository;
    @Autowired private ActionMapper mapper;
    
    public ActionDTO add(ActionDTO actionDTO){
        Action action = mapper.mapTo(actionDTO);
        actionRepository.save(action);
        return mapper.mapTo(action);
    }
    
    public ActionDTO get(Long id){
        Action action = actionRepository.getOne(id);
        return mapper.mapTo(action);
    }
    
    public List<ActionDTO> getAll(){
    	List<Action> actions = actionRepository.findAll();
        return mapper.mapTo(actions);
    }
    
    public String delete(Long id){
    	actionRepository.deleteById(id);
        return "Deleted";
    }

}
