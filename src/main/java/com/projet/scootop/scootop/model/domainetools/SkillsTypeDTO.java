package com.projet.scootop.scootop.model.domainetools;

import com.projet.scootop.scootop.domain.domaintools.Skill;

public class SkillsTypeDTO {

    public Integer id;
    public String name;
    public Skill skillsFamilly;

    public static SkillsTypeDTO get(Integer id, String name) {
        SkillsTypeDTO skillsTypeDTO = new SkillsTypeDTO();
        skillsTypeDTO.id = id;
        skillsTypeDTO.name = name;
        return skillsTypeDTO;
    }
    public static SkillsTypeDTO create(String name) {
        SkillsTypeDTO skillsTypeDTO = new SkillsTypeDTO();
        skillsTypeDTO.name = name;
        return skillsTypeDTO;
    }

    @Override
    public String toString() {
        return "SkillsTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
