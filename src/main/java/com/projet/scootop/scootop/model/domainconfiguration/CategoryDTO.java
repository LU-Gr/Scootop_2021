package com.projet.scootop.scootop.model.domainconfiguration;

import com.projet.scootop.scootop.domain.domaintools.CategoryType;

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
