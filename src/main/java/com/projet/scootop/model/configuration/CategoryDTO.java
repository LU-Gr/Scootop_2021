package com.projet.scootop.model.configuration;

import lombok.Getter;
import lombok.Setter;

public class CategoryDTO {

	@Getter @Setter
    private int id;
    
	@Getter @Setter
    private String name;

	@Getter @Setter
    private CategoryTypeDTO categoryType;
}
