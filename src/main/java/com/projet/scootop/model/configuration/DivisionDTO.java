package com.projet.scootop.model.configuration;

import lombok.Getter;
import lombok.Setter;

public class DivisionDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private String name;
	   
    @Getter @Setter
    private LeagueDTO league;
     
    @Getter @Setter
    private CategoryDTO category;

}
