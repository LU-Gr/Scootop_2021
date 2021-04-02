package com.projet.scootop.scootop.model.domainconfiguration;

import java.util.List;

import com.projet.scootop.scootop.domain.domaintools.CategoryType;
import com.projet.scootop.scootop.domain.domaintools.CompetitionType;

public class CategoryDTO {

    int id;
    public String name;
    public List<CompetitionType> competionType;

    public CategoryType categoryType;

    public static CategoryDTO create(String name, List<CompetitionType> competionType, CategoryType categoryType) {
        CategoryDTO category = new CategoryDTO();
        category.name = name;
        category.competionType = competionType;
        category.categoryType = categoryType;
        return category;
    }
    public static CategoryDTO get(int id, String name, List<CompetitionType> competionType, CategoryType categoryType) {
        CategoryDTO category = new CategoryDTO();
        category.id = id;
        category.name = name;
        category.competionType = competionType;
        category.categoryType = categoryType;
        return category;
    }
}
