package com.projet.scootop.scootop.domain.provider;

import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.user.User;
import com.projet.scootop.scootop.user.UserType;

import javax.persistence.*;

@Entity
@Table(name = "Analyste")
//Role restrictif qui sert juste a faire analyse des joueurs lors des matchs
public class Analyste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @OneToOne
    @JoinColumn(name = "USER_TYPE_ID")
    public User user;
    public Integer tarif;
    public Integer experience;
    @ManyToOne
    public MatchSheet matchSheet;



    public Analyste() {
    }

    public Analyste(User user, Integer tarif, Integer experience, MatchSheet matchSheet) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.types
        ) {
            if(userType.type.equals("analyste")){
                isCorrect=true;
            }
        }
        if(!isCorrect){
            throw new Exception("L'utilisateur doit être un analyste");
        }

        this.user = user;
        this.tarif = tarif;
        this.experience = experience;
        this.matchSheet = matchSheet;
    }

}
