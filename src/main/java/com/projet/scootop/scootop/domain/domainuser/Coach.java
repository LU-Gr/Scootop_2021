package com.projet.scootop.scootop.domain.domainuser;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.user.User;
import com.projet.scootop.scootop.domain.user.UserType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Coach")

public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User user;

    @ManyToMany(mappedBy = "coaches", fetch = FetchType.LAZY)
    public List<Team> teams;


    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Coach() {
    }

    public Coach(User user, List<Team> teams) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.types
        ) {
            if(userType.type.equals("coach")){
                isCorrect=true;
            }
        }
        if(!isCorrect){
            throw new Exception("L'utilisateur doit être un coach");
        }

        this.user = user;
        this.teams = teams;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
