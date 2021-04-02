package com.projet.scootop.scootop.service.domaintools;

import com.projet.scootop.scootop.domain.domaintools.Skill;
import com.projet.scootop.scootop.model.domainetools.SkillsFamillyDTO;
import com.projet.scootop.scootop.repository.domainetools.SkillsFamillyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class SkillsFamillyService {
    @Autowired
    public SkillsFamillyRepository skillsFamillyRepository;
    public SkillsFamillyDTO addSkillsFamilly(SkillsFamillyDTO skillsFamillyDTO) {
        Skill skillsFamilly = new Skill(skillsFamillyDTO.name);
        skillsFamillyRepository.save(skillsFamilly);
        return skillsFamillyDTO;
    }
    public SkillsFamillyDTO get(Integer id){

        Skill skillsFamilly = skillsFamillyRepository.findById(id).orElse(null);
        if(skillsFamilly==null){
            return null;
        }

        return SkillsFamillyDTO.get(skillsFamilly.id,skillsFamilly.name);
    }

    public List<SkillsFamillyDTO> getAll(){

        List<Skill> skillsFamillys = skillsFamillyRepository.findAll();
        return skillsFamillys.stream().map(skillsFamilly -> SkillsFamillyDTO.get(skillsFamilly.id,skillsFamilly.name)).collect(Collectors.toList());
    }


    public String delete(Integer id){
        Skill scoot = skillsFamillyRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        skillsFamillyRepository.deleteById(id);

        return "Deleted";
    }

}
