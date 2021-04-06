package com.projet.scootop.scootop.domain.domainuser;

import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.domain.services.Shortlist;
import com.projet.scootop.scootop.domain.user.User;
import com.projet.scootop.scootop.domain.user.UserType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Scoot")

public class Scoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User user;

    @ManyToMany (mappedBy = "scoots")
    public List<Club> clubs;

    @OneToOne
    @JoinColumn(name = "Shortlist_id")
    public Shortlist shortlist;

    public Scoot(User user, List<Club> clubs, Shortlist shortlist) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.types
             ) {
            if(userType.type.equals("scoot")){
                isCorrect=true;
            }
        }
        if(!isCorrect){
            throw new Exception("L'utilisateur doit être un scoot");
        }
        this.user = user;
        this.clubs = clubs;
        this.shortlist = shortlist;
    }

    public Scoot() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

    public Shortlist getShortlist() {
        return shortlist;
    }

    public void setShortlist(Shortlist shortlist) {
        this.shortlist = shortlist;
    }
}
