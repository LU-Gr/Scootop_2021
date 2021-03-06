package com.projet.scootop.domain.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;

import java.util.List;

@Entity
@Table(name = "Coach")

public class Coach {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @JoinColumn
    @Getter @Setter
    private User user;
    
    @ManyToMany
    @JoinTable(name = "team_coach", 
			joinColumns = @JoinColumn(name = "coach_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id"))
    @Getter @Setter
    @JsonIgnoreProperties("coaches")
    private List<Team> teams;

    public Coach() {
    }

    public Coach(User user, List<Team> teams) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.getUserTypes()) {
            if(userType.getType().equals("coach")){
                isCorrect=true;
            }
        }
        if(!isCorrect){
            throw new Exception("L'utilisateur doit être un coach");
        }

        this.user = user;
        this.teams = teams;
    }
}
