package com.projet.scootop.model.domainuser;

import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.domain.services.Shortlist;
import com.projet.scootop.domain.user.User;

public class ScootDTO {
    public Long id;
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
    public static ScootDTO get(Long id, User user, List<Club> clubs, Shortlist shortlist) {
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
