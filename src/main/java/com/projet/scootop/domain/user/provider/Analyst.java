package com.projet.scootop.domain.user.provider;

import javax.persistence.*;

import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Analyste")
//Role restrictif qui sert juste a faire analyse des joueurs lors des matchs
public class Analyst {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private Double tarif;
    
    @Getter @Setter
    private Integer experience;
    
    @OneToOne
    @JoinColumn
    @Getter @Setter
    private User user;
    
    @ManyToOne
    @Getter @Setter
    private Match matchSheet;

    public Analyst() {
    }

    public Analyst(User user, Double tarif, Integer experience, Match matchSheet) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.getTypes()) {
            if(userType.getType().equals("analyste")){
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
