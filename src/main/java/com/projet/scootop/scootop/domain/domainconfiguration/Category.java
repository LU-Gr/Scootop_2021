package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domaintools.CategoryType;


// différente tranches d'âge. Ex: U-19, U-17
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    @OneToOne
    public CategoryType categoryType;

    public Category() {

    }

    public Category(String name, CategoryType categoryType) {
        super();
        this.name = name;
        this.categoryType = categoryType;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

}
