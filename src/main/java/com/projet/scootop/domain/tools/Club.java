package com.projet.scootop.domain.tools;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.user.Contact;
import com.projet.scootop.domain.user.domain.Scoot;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Club")
public class Club {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String colorInside;
    
    @Getter @Setter
    private String colorOutSide;

    @Getter @Setter
    private String name;
    
    @OneToOne
    @Getter @Setter
    private Contact contact;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    @Getter @Setter
    @JsonIgnoreProperties({"club"})
    private List<Team> teams;

    @ManyToMany
    @JoinTable(name="club_scoots", 
    		joinColumns = @JoinColumn(name ="club_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "scoot_id",referencedColumnName = "id"))
    @Getter @Setter
    private List<Scoot> scoots;


    public Club() {
    	teams = new ArrayList<>();
    	scoots = new ArrayList<>();
    }

    public Club(String name, Contact contact, String colorInside, String colorOutSide, List<Team> teams, List<Scoot> scoots) throws Exception {
        super();
        this.name = name;
        this.contact=contact;
        this.colorInside=colorInside;
        this.colorOutSide=colorOutSide;
        this.teams=teams;
        this.scoots=scoots;

        if(scoots.size() <= 10) {
            for (int i = 0; i < scoots.size(); i++) {
                if( scoots.get(i).getClubs().size() < 10){
                 scoots.get(i).getClubs().add(this);
                }
                else throw new Exception("Vous ne pouvez ajouter plus de 10 clubs pour un scoot");
            }
        }else{
            throw new Exception("Un club ne peut ajouter plus de 10 Scoots ");
        }


    }

}
