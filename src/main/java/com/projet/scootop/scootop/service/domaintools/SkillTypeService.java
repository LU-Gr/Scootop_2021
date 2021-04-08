package com.projet.scootop.scootop.service.domaintools;

import com.projet.scootop.scootop.domain.domaintools.SkillType;
import com.projet.scootop.scootop.model.domainetools.SkillTypeDTO;
import com.projet.scootop.scootop.repository.domainetools.SkillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillTypeService {
    @Autowired
    public SkillTypeRepository skillTypeRepository;
    public SkillTypeDTO addSkillType(SkillTypeDTO skillTypeDTO) {
        SkillType skillsType = new SkillType(skillTypeDTO.getName());
        skillTypeRepository.save(skillsType);
        return skillTypeDTO;
    }
    public SkillTypeDTO get(Long id){

        SkillType skillsType = skillTypeRepository.findById(id).orElse(null);
        if(skillsType==null){
            return null;
        }

        return SkillTypeDTO.get(skillsType.getId(),skillsType.getName());
    }

    public List<SkillTypeDTO> getAll(){

        List<SkillType> skillsTypes = skillTypeRepository.findAll();
        return skillsTypes.stream().map(skillsType -> SkillTypeDTO.get(skillsType.getId(),skillsType.getName())).collect(Collectors.toList());
    }


    public String delete(Long id){
        SkillType scoot = skillTypeRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        skillTypeRepository.deleteById(id);

        return "Deleted";
    }

}
