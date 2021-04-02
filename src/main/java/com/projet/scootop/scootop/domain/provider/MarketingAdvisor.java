package com.projet.scootop.scootop.domain.provider;

import com.projet.scootop.scootop.user.User;
import com.projet.scootop.scootop.user.UserType;


import javax.persistence.*;

@Entity
@Table(name = "MarketingAdvisor")

public class MarketingAdvisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @OneToOne
    public User user;
    @ManyToOne
    public Agence agence;




    public MarketingAdvisor(User user, Agence agence) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.types
        ) {
            if(userType.type.equals("Marketing Advisor")){
                isCorrect=true;
            }
        }
        if(!isCorrect){
            throw new Exception("L'utilisateur doit être un Marketing Advisor");
        }

        this.user = user;
        this.agence = agence;
    }
    public MarketingAdvisor() {
    }
}
