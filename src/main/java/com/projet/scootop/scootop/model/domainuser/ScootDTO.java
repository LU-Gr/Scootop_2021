package com.projet.scootop.scootop.model.domainuser;

import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.domain.services.Shortlist;
import com.projet.scootop.scootop.user.User;

import java.util.List;

public class ScootDTO {
    public Integer id;
    public User user;
    public List<Club> clubs;
    public Shortlist shortlist;

    public static ScootDTO create(User user, List<Club> clubs, Shortlist shortlist) {
        ScootDTO scoot = new ScootDTO();
        scoot.user = user;
        scoot.clubs = clubs;
        scoot.shortlist = shortlist;
        return scoot;
    }
    public static ScootDTO get(Integer id, User user, List<Club> clubs, Shortlist shortlist) {
        ScootDTO scoot = new ScootDTO();
        scoot.id = id;
        scoot.user = user;
        scoot.clubs = clubs;
        scoot.shortlist = shortlist;
        return scoot;
    }


    @Override
    public String toString() {
        return "ScootDTO{" +
                "id=" + id +
                ", user=" + user +
                ", clubs=" + clubs +
                '}';
    }
}
