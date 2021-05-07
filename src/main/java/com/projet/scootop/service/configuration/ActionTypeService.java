package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.ActionType;
import com.projet.scootop.model.configuration.ActionTypeDTO;
import com.projet.scootop.repository.configuration.ActionTypeRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ActionTypeService {
	
    @Autowired
    public ActionTypeRepository skillRepository;
    
    public ActionTypeDTO addSkill(ActionTypeDTO skillsDTO) {
        ActionType skills = new ActionType(skillsDTO.getName());
        skillRepository.save(skills);
        return skillsDTO;
    }
    
    public ActionTypeDTO get(Long id){

        ActionType skillsFamilly = skillRepository.findById(id).orElse(null);
        if(skillsFamilly==null){
            return null;
        }

        return ActionTypeDTO.get(skillsFamilly.getId(),skillsFamilly.getName());
    }

    public List<ActionTypeDTO> getAll(){

        List<ActionType> skills = skillRepository.findAll();
        return skills.stream().map(skill -> ActionTypeDTO.get(skill.getId(),skill.getName())).collect(Collectors.toList());
    }


    public String delete(Long id){
        ActionType scoot = skillRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        skillRepository.deleteById(id);

        return "Deleted";
    }

}
