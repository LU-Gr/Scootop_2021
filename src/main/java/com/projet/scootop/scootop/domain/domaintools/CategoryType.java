package com.projet.scootop.scootop.domain.domaintools;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

// définit l'âge min/max de la catégorie
@Entity
@Table(name = "CategoryType")

public class CategoryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    //TODO: Supprimer name
    public String name;
    public int ageMin;
    public int ageMax;
    public LocalDate dateAgeMax;


    public CategoryType(String name,LocalDate dateAgeMax) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", ageMin=" + ageMin +
                ", ageMax=" + dateAgeMax +
                '}';
    }
}
