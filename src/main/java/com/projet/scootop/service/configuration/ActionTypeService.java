package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.ActionType;
import com.projet.scootop.mappers.configuration.ActionTypeMapper;
import com.projet.scootop.model.configuration.ActionTypeDTO;
import com.projet.scootop.repository.configuration.ActionTypeRepository;

import java.util.List;


@Service
public class ActionTypeService {
	
    @Autowired private ActionTypeRepository skillRepository;
    @Autowired private ActionTypeMapper mapper;
    
    public ActionTypeDTO addSkill(ActionTypeDTO skillsDTO) {
        ActionType actionType = mapper.mapTo(skillsDTO);
        skillRepository.save(actionType);
        return mapper.mapToDTO(actionType);
    }
    
    public ActionTypeDTO get(Long id){

        ActionType actionType = skillRepository.findById(id).orElse(null);
        if(actionType==null){
            return null;
        }

        return mapper.mapToDTO(actionType);
    }

    public List<ActionTypeDTO> getAll(){

        List<ActionType> skills = skillRepository.findAll();
        return mapper.mapToDTO(skills);
    }


    public String delete(Long id){
        ActionType scoot = skillRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        skillRepository.deleteById(id);

        return "Deleted";
    }

	public ActionTypeDTO update(ActionTypeDTO body) {
		ActionType actionType = mapper.mapTo(body);
        skillRepository.save(actionType);
        return mapper.mapToDTO(actionType);
	}

}
