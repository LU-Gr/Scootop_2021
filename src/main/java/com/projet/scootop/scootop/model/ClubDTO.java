package com.projet.scootop.scootop.model;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.scootop.model.domainuser.ScootDTO;
import com.projet.scootop.scootop.user.Contact;

import java.util.List;

public class ClubDTO {
    public String colorInside;
    public String colorOutSide;
    public Contact contact;
    public String name;
    public Integer id;
    public List<Scoot> scoot;
    public List<Team> teams;
    public static ClubDTO create(String name, Contact contact, String colorInside, String colorOutSide, List<Team> teams,List<Scoot> scoot) {
        ClubDTO club = new ClubDTO();
        club.name=name;
        club.contact=contact;
        club.teams=teams;
        club.colorInside=colorInside;
        club.colorOutSide=colorOutSide;
        club.scoot=scoot;
        return club;
    }
    public static ClubDTO get(Integer id,String name, Contact contact, String colorInside, String colorOutSide, List<Team> teams,List<Scoot> scoot) {
        ClubDTO club = new ClubDTO();
        club.name=name;
        club.id=id;
        club.contact=contact;
        club.teams=teams;
        club.colorInside=colorInside;
        club.colorOutSide=colorOutSide;
        club.scoot=scoot;
        return club;
    }

    @Override
    public String toString() {
        return "ClubDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
