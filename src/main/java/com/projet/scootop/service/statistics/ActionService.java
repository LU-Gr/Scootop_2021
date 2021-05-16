package com.projet.scootop.service.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistics.Action;
import com.projet.scootop.mappers.statistics.ActionMapper;
import com.projet.scootop.model.statistics.ActionDTO;
import com.projet.scootop.repository.statistics.ActionRepository;

import java.util.List;

@Service
public class ActionService {
	
    @Autowired private ActionRepository actionRepository;
    @Autowired private ActionMapper mapper;
    
    public ActionDTO add(ActionDTO actionDTO){
        Action action = mapper.mapTo(actionDTO);
        actionRepository.save(action);
        return mapper.mapToDTO(action);
    }
    
    public ActionDTO get(Long id){
        Action action = actionRepository.getOne(id);
        return mapper.mapToDTO(action);
    }
    
    public List<ActionDTO> getAll(){
    	List<Action> actions = actionRepository.findAll();
        return mapper.mapToDTO(actions);
    }
    
    public String delete(Long id){
    	actionRepository.deleteById(id);
        return "Deleted";
    }

	public ActionDTO update(ActionDTO actionDTO) {
		Action action = mapper.mapTo(actionDTO);
        actionRepository.save(action);
        return mapper.mapToDTO(action);
	}

}
