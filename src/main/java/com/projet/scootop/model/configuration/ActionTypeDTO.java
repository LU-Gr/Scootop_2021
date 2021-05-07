package com.projet.scootop.model.configuration;

import lombok.Getter;
import lombok.Setter;

public class ActionTypeDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;

    public static ActionTypeDTO create(String name) {

        ActionTypeDTO skillsfamilly = new ActionTypeDTO();
        skillsfamilly.name = name;

        return skillsfamilly;
    }
    public static ActionTypeDTO get(Long id, String name) {

        ActionTypeDTO skillsfamilly = new ActionTypeDTO();
        skillsfamilly.id = id;
        skillsfamilly.name = name;

        return skillsfamilly;
    }

    @Override
    public String toString() {
        return "SkillsFamillyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
