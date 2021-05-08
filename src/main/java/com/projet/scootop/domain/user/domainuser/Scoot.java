package com.projet.scootop.domain.user.domainuser;

import javax.persistence.*;

import com.projet.scootop.domain.services.Shortlist;
import com.projet.scootop.domain.tools.Club;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
@Table(name = "Scoot")

public class Scoot {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @JoinColumn
    @Getter @Setter
    private User user;

    @ManyToMany (mappedBy = "scoots")
    @Getter @Setter
    private List<Club> clubs;

    @OneToOne
    @JoinColumn(name = "Shortlist_id")
    @Getter @Setter
    private Shortlist shortlist;
    
    @ManyToMany
    @JoinTable(name = "shortlist_scoot", 
	joinColumns = @JoinColumn(name = "scoot_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "shortlist_id", referencedColumnName = "id"))
    @Getter @Setter
    private List<Shortlist> FollowedShortlists;

    public Scoot(User user, List<Club> clubs, Shortlist shortlist) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.getTypes()) {
            if(userType.getType().equals("scoot")){
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
}
