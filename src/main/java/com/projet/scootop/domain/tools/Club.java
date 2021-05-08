package com.projet.scootop.domain.tools;

import javax.persistence.*;

import com.projet.scootop.domain.user.Contact;
import com.projet.scootop.domain.user.domainuser.Scoot;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Club")
public class Club {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private String colorInside;
    
    @Getter @Setter
    private String colorOutSide;

    @OneToOne
    //@JoinColumn(name = "Contact_id")
    @Getter @Setter
    private Contact contact;

    @Getter @Setter
    private String name;

    @ManyToMany
    /*@JoinTable(name="club_scoot", joinColumns = @JoinColumn(name ="club_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "scoot_id",referencedColumnName = "id"))*/
    @Getter @Setter
    private List<Scoot> scoots;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="team_id")
    @Getter @Setter
    private List<Team> teams;

    public Club() {
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
