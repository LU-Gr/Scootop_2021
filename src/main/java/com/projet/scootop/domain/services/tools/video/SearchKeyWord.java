package com.projet.scootop.domain.services.tools.video;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "search_keywords")

public class SearchKeyWord {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String name;

    @ManyToMany
    @Getter @Setter
    @JsonIgnoreProperties("keywords")
    private List<Video> videos;


    public SearchKeyWord(String name) {
        this.name = name;
    }

    public SearchKeyWord() {

    }
}