package com.projet.scootop.model.configuration;

import com.projet.scootop.domain.configuration.CategoryType;

import lombok.Getter;
import lombok.Setter;

public class CategoryDTO {

	@Getter @Setter
    private int id;
    
	@Getter @Setter
    private String name;

	@Getter @Setter
    private CategoryType categoryType;
}
