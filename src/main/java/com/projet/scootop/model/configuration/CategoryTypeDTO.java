package com.projet.scootop.model.configuration;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

public class CategoryTypeDTO {

	@Getter @Setter
    private Integer id;
	
	@Getter @Setter
    private int ageMin;
	
	@Getter @Setter
    private int ageMax;
	
	@Getter @Setter
    private LocalDate dateAgeMax;

}
