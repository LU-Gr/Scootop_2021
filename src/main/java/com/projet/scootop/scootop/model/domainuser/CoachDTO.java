package com.projet.scootop.scootop.model.domainuser;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.user.User;

import java.util.List;

public class CoachDTO {

    public Long id;
    public User user;

    public List<Team> teams;



    public static CoachDTO create(User user, List<Team> teams) {
        CoachDTO coach = new CoachDTO();
        coach.user = user;
        coach.teams = teams;
        return coach;
    }
    public static CoachDTO get(Long id, User user, List<Team> teams) {
        CoachDTO coach = new CoachDTO();
        coach.id = id;
        coach.user = user;
        coach.teams = teams;
        return coach;
    }

    @Override
    public String toString() {
        return "CoachDTO{" +
                "id=" + id +
                ", user=" + user +
                ", teams=" + teams +
                '}';
    }
}
