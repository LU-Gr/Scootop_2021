package com.projet.scootop.scootop.domain.domaintools;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.servicetools.videosservices.Video;

import javax.persistence.*;

// Caractéristique d'une compétiton
//TODO: Rename compétition
@Entity
@Table(name = "CompetitionType")

public class CompetitionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    
    //TODO: Ajouter Type
    
    //TODO: Supprimer
    @OneToOne
    public Video video;

    public int playerMax;
    public int playerMin;

    public int titulaire;
    public int remplacant;

    public int substition;

    //temps de durée du match
    //durée de la mi-temps ?
    //TODO renommer
    public int time;

    //TODO Supprimer
    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    public Category category;

    public CompetitionType(String name, Video video, int playerMax, int playerMin, int titulaire, int remplacant, int substition, int time, Category category) {
        super();
        this.name = name;
        this.video = video;
        this.playerMax = playerMax;
        this.playerMin = playerMin;
        this.titulaire = titulaire;
        this.remplacant = remplacant;
        this.substition = substition;
        this.time = time;
        this.category = category;
    }

    public CompetitionType() {

    }


    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CompetitionTypeRepository{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public int getPlayerMax() {
        return playerMax;
    }

    public void setPlayerMax(int playerMax) {
        this.playerMax = playerMax;
    }

    public int getPlayerMin() {
        return playerMin;
    }

    public void setPlayerMin(int playerMin) {
        this.playerMin = playerMin;
    }

    public int getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(int titulaire) {
        this.titulaire = titulaire;
    }

    public int getRemplacant() {
        return remplacant;
    }

    public void setRemplacant(int remplacant) {
        this.remplacant = remplacant;
    }

    public int getSubstition() {
        return substition;
    }

    public void setSubstition(int substition) {
        this.substition = substition;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
