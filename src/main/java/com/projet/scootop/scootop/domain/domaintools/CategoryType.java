package com.projet.scootop.scootop.domain.domaintools;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

// définit l'âge min/max de la catégorie
@Entity
@Table(name = "CategoryType")

public class CategoryType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private int ageMin;
    @Getter @Setter
    private int ageMax;
    @Getter @Setter
    private LocalDate dateAgeMax;


    public CategoryType(LocalDate dateAgeMax) {
        this.dateAgeMax = dateAgeMax;
        this.ageMax = CategoryCalcul(dateAgeMax);
        this.ageMin = this.ageMax - 5;
    }

    public CategoryType() {
    }

    public int CategoryCalcul(LocalDate ageMax) {
            //validate inputs ...
            LocalDate currentDate= LocalDate.now();
            return Period.between(ageMax, currentDate).getYears();
    }

    @Override
    public String toString() {
        return "CategorieType{" +
                "id=" + id +
                ", ageMin=" + ageMin +
                ", ageMax=" + dateAgeMax +
                '}';
    }
}
