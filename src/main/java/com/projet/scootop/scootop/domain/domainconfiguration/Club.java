package com.projet.scootop.scootop.domain.domainconfiguration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.projet.scootop.scootop.domain.domainuser.Coach;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.user.Contact;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String colorInside;
    public String colorOutSide;

    @OneToOne
    @JoinColumn(name = "Contact_id")
    public Contact contact;

    public String name;

    @ManyToMany
    @JoinTable(name="club_scoot", joinColumns = @JoinColumn(name ="club_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "scoot_id",referencedColumnName = "id"))
    public List<Scoot> scoots;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="team_id")
    public List<Team> teams;

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

                if( scoots.get(i).clubs.size() < 10){

                 scoots.get(i).clubs.add(this);

                }else

                    throw new Exception("Vous ne pouvez ajouter plus de 10 clubs pour un scoot");


            }
        }else{

            throw new Exception("Un club ne peut ajouter plus de 10 Scoots ");
        }


    }


    public Integer getId() {
        return id;
    }

    public String getColorInside() {
        return colorInside;
    }

    public void setColorInside(String colorInside) {
        this.colorInside = colorInside;
    }

    public String getColorOutSide() {
        return colorOutSide;
    }

    public void setColorOutSide(String colorOutSide) {
        this.colorOutSide = colorOutSide;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Scoot> getScoots() {
        return scoots;
    }

    public void setScoots(List<Scoot> scoots) {
        this.scoots = scoots;
    }

    public List<Team> getTeams(){
        return teams;
    }

    public void setTeams(List<Team> teams){
        this.teams = teams;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
