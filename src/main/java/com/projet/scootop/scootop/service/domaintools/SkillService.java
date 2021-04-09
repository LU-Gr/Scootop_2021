package com.projet.scootop.scootop.service.domaintools;

import com.projet.scootop.scootop.domain.domaintools.Skill;
import com.projet.scootop.scootop.model.domaintools.SkillDTO;
import com.projet.scootop.scootop.repository.domainetools.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SkillService {
	
    @Autowired
    public SkillRepository skillRepository;
    
    public SkillDTO addSkill(SkillDTO skillsDTO) {
        Skill skills = new Skill(skillsDTO.getName());
        skillRepository.save(skills);
        return skillsDTO;
    }
    
    public SkillDTO get(Long id){

        Skill skillsFamilly = skillRepository.findById(id).orElse(null);
        if(skillsFamilly==null){
            return null;
        }

        return SkillDTO.get(skillsFamilly.getId(),skillsFamilly.getName());
    }

    public List<SkillDTO> getAll(){

        List<Skill> skills = skillRepository.findAll();
        return skills.stream().map(skill -> SkillDTO.get(skill.getId(),skill.getName())).collect(Collectors.toList());
    }


    public String delete(Long id){
        Skill scoot = skillRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        skillRepository.deleteById(id);

        return "Deleted";
    }

}
