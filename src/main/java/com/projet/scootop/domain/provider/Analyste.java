package com.projet.scootop.domain.provider;

import javax.persistence.*;

import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Analyste")
//Role restrictif qui sert juste a faire analyse des joueurs lors des matchs
public class Analyste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @OneToOne
    @JoinColumn
    @Getter @Setter
    private User user;
    
    @Getter @Setter
    private Double tarif;
    
    @Getter @Setter
    private Integer experience;
    
    @ManyToOne
    @Getter @Setter
    private MatchSheet matchSheet;

    public Analyste() {
    }

    public Analyste(User user, Double tarif, Integer experience, MatchSheet matchSheet) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.getTypes()) {
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
