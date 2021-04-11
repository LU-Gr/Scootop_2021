package com.projet.scootop.domain.domainuser;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.projet.scootop.domain.domainconfiguration.Team;
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
    
    @ManyToMany(mappedBy = "coaches", fetch = FetchType.LAZY)
    @Getter
    private List<Team> teams;

    public Coach() {
    }

    public Coach(User user, List<Team> teams) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.getTypes()) {
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
}
