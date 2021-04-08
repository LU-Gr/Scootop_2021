package com.projet.scootop.scootop.model.domainetools;

import com.projet.scootop.scootop.domain.domaintools.Skill;

import lombok.Getter;
import lombok.Setter;

public class SkillTypeDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private Skill skillsFamilly;

    public static SkillTypeDTO get(Long id, String name) {
        SkillTypeDTO skillsTypeDTO = new SkillTypeDTO();
        skillsTypeDTO.id = id;
        skillsTypeDTO.name = name;
        return skillsTypeDTO;
    }
    public static SkillTypeDTO create(String name) {
        SkillTypeDTO skillsTypeDTO = new SkillTypeDTO();
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
