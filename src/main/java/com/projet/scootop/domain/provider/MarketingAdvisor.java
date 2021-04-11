package com.projet.scootop.domain.provider;

import javax.persistence.*;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MarketingAdvisor")

public class MarketingAdvisor {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @OneToOne
    @Getter @Setter
    private User user;
    
    @ManyToOne
    @Getter @Setter
    private Agence agence;

    public MarketingAdvisor(User user, Agence agence) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.getTypes()) {
            if(userType.getType().equals("Marketing Advisor")){
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
