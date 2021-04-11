package com.projet.scootop.model.domainconfiguration;

import com.projet.scootop.domain.domaintools.CategoryType;

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
