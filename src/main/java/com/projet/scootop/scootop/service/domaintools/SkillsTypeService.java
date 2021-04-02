package com.projet.scootop.scootop.service.domaintools;

import com.projet.scootop.scootop.domain.domaintools.SkillType;
import com.projet.scootop.scootop.model.domainetools.SkillsTypeDTO;
import com.projet.scootop.scootop.repository.domainetools.SkillsTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillsTypeService {
    @Autowired
    public SkillsTypeRepository skillsTypeRepository;
    public SkillsTypeDTO addSkillsType(SkillsTypeDTO skillsTypeDTO) {
        SkillType skillsType = new SkillType(skillsTypeDTO.name);
        skillsTypeRepository.save(skillsType);
        return skillsTypeDTO;
    }
    public SkillsTypeDTO get(Integer id){

        SkillType skillsType = skillsTypeRepository.findById(id).orElse(null);
        if(skillsType==null){
            return null;
        }

        return SkillsTypeDTO.get(skillsType.id,skillsType.name);
    }

    public List<SkillsTypeDTO> getAll(){

        List<SkillType> skillsTypes = skillsTypeRepository.findAll();
        return skillsTypes.stream().map(skillsType -> SkillsTypeDTO.get(skillsType.id,skillsType.name)).collect(Collectors.toList());
    }


    public String delete(Integer id){
        SkillType scoot = skillsTypeRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        skillsTypeRepository.deleteById(id);

        return "Deleted";
    }

}
