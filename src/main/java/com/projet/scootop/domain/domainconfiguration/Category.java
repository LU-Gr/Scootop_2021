package com.projet.scootop.domain.domainconfiguration;

import javax.persistence.*;

import com.projet.scootop.domain.domaintools.CategoryType;

import lombok.Getter;
import lombok.Setter;


// différente tranches d'âge. Ex: U-19, U-17
@Entity
@Table(name = "CATEGORY")
public class Category {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String name;

    @OneToOne
    @Getter @Setter
    private CategoryType categoryType;

    public Category() {

    }

    public Category(String name, CategoryType categoryType) {
        super();
        this.name = name;
        this.categoryType = categoryType;
    }
}
