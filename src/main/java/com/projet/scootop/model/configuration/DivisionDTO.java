package com.projet.scootop.model.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

public class DivisionDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private String name;
	   
    @Getter @Setter
    @JsonIgnoreProperties("divisions")
    private LeagueDTO league;
     
    @Getter @Setter
    private CategoryDTO category;

}
