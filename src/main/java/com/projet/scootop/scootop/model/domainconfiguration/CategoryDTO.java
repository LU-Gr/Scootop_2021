package com.projet.scootop.scootop.model.domainconfiguration;

import com.projet.scootop.scootop.domain.domaintools.CategoryType;

public class CategoryDTO {

    int id;
    public String name;

    public CategoryType categoryType;

    public static CategoryDTO create(String name, CategoryType categoryType) {
        CategoryDTO category = new CategoryDTO();
        category.name = name;
        category.categoryType = categoryType;
        return category;
    }
    public static CategoryDTO get(int id, String name, CategoryType categoryType) {
        CategoryDTO category = new CategoryDTO();
        category.id = id;
        category.name = name;
        category.categoryType = categoryType;
        return category;
    }
}
