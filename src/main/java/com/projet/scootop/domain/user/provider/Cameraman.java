package com.projet.scootop.domain.user.provider;

import javax.persistence.*;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cameraman")

public class Cameraman {

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


    public Cameraman(User user, Double tarif, Integer experience) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.getUserTypes()) {
            if(userType.getType().equals("cameraman")){
                isCorrect=true;
            }
        }
        if(!isCorrect){
            throw new Exception("L'utilisateur doit être un cameraman");
        }
        this.user = user;
        this.tarif = tarif;
        this.experience = experience;
    }

    public Cameraman() {
    }
}
