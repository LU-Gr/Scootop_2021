package com.projet.scootop.domain.user.provider;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("marketingAdvisors")
    private Agence agence;

    public MarketingAdvisor(User user, Agence agence) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.getUserTypes()) {
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
