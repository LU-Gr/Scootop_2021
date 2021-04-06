package com.projet.scootop.scootop.domain.domaintools;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.domain.servicetools.videosservices.Video;

import javax.persistence.*;

// Caractéristique d'une compétiton
@Entity
@Table(name = "Competition")

public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    
    //TODO: Ajouter Type
   

    public int playerMax;
    public int playerMin;

    public int titulaire;
    public int remplacant;

    public int substition;

    public int dureeMiTemps;

    public Competition(String name, Video video, int playerMax, int playerMin, int titulaire, int remplacant, int substition, int time, Category category) {
        super();
        this.name = name;
        this.playerMax = playerMax;
        this.playerMin = playerMin;
        this.titulaire = titulaire;
        this.remplacant = remplacant;
        this.substition = substition;
        this.dureeMiTemps = time;
    }

    public Competition() {

    }


    public Long getId() {
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
        return dureeMiTemps;
    }

    public void setTime(int time) {
        this.dureeMiTemps = time;
    }
}
