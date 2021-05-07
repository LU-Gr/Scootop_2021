package com.projet.scootop.model.configuration;

import lombok.Getter;
import lombok.Setter;

public class DivisionDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private String name;

    @Override
    public String toString() {
        return "DivisionsRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
