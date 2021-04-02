package com.projet.scootop.scootop.service.stastistical;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.stastistical.Goal;
import com.projet.scootop.scootop.domain.stastistical.Action;
import com.projet.scootop.scootop.model.statistical.GoalDTO;
import com.projet.scootop.scootop.model.statistical.SkillDTO;
import com.projet.scootop.scootop.repository.statistical.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Service

public class SkillService {
    @Autowired
    public SkillRepository skillRepository;
    public SkillDTO add(SkillDTO skillDTO){
        Action skill = new Action(skillDTO.id,skillDTO.matchSheet,skillDTO.player,skillDTO.isDefensive,skillDTO.successSkill,skillDTO.isLong);
        skillRepository.save(skill);
        return  skillDTO;

    }
    public SkillDTO get(Integer id){
        return null;
    }
    public List<SkillDTO> getAll(){


        return null;
    }
    public String delete(Integer id){

        skillRepository.deleteById(id);

        return "Deleted";
    }

}
