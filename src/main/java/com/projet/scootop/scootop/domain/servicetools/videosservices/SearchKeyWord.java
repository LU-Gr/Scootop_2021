package com.projet.scootop.scootop.domain.servicetools.videosservices;

import javax.persistence.*;

@Entity
@Table(name = "SEARCHKEYWORDS")

public class SearchKeyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    String name;

    @ManyToOne
    public Video video;


    public SearchKeyWord(String name) {
        this.name = name;
    }

    public SearchKeyWord() {

    }
}