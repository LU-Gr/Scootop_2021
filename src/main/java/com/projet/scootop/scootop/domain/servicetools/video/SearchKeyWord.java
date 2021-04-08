package com.projet.scootop.scootop.domain.servicetools.video;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "search_keywords")

public class SearchKeyWord {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    String name;

    @ManyToMany
    public List<Video> videos;


    public SearchKeyWord(String name) {
        this.name = name;
    }

    public SearchKeyWord() {

    }
}