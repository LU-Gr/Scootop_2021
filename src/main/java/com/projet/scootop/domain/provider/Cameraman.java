package com.projet.scootop.domain.provider;

import javax.persistence.*;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;

@Entity
@Table(name = "Cameraman")

public class Cameraman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Integer tarif;
    public Integer experience;
    @OneToOne
    @JoinColumn(name = "USER_TYPE_ID")
    public User user;

    @Override
    public String toString() {
        return "Cameraman{" +
                "id=" + id +
                ", tarif=" + tarif +
                ", experience=" + experience +
                ", user=" + user +
                '}';
    }

    public Cameraman(User user, Integer tarif, Integer experience) throws Exception {
        super();
        boolean isCorrect=false;
        for (UserType userType: user.types
        ) {
            if(userType.type.equals("cameraman")){
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
