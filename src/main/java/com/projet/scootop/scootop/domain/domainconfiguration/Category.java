package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domaintools.CategoryType;
import com.projet.scootop.scootop.domain.domaintools.CompetitionType;

import java.util.List;


// différente tranches d'âge. Ex: U-19, U-17
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    //TODO Supprimer
    @OneToMany
    @JoinColumn(name = "COMPETITION_TYPE_ID")
    public List<CompetitionType> competitionTypes;

    @OneToOne
    public CategoryType categoryType;

    public Category() {

    }

    public Category(String name, List<CompetitionType> competitionTypes, CategoryType categoryType) {
        super();
        this.name = name;
        this.competitionTypes = competitionTypes;
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

    public List<CompetitionType> getCompetitionTypes() {
        return competitionTypes;
    }

    public void setCompetitionTypes(List<CompetitionType> competitionTypes) {
        this.competitionTypes = competitionTypes;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

}
