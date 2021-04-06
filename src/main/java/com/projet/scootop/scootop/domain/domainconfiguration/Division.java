package com.projet.scootop.scootop.domain.domainconfiguration;

import javax.persistence.*;

/*
 * Exemple: Ligue 1
 */
@Entity
@Table(name = "Division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "divisions_id" )
    private League league;
    
    //TODO: Ajouter Category
    @ManyToOne
    @JoinColumn
    private Category category;
    
    

    public Division(){
    }

    public Division( String name) {
        super();
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
    
    
}
