package com.projet.scootop.scootop.domain.domainuser;

import com.projet.scootop.scootop.domain.user.User;
import com.projet.scootop.scootop.domain.user.UserType;

import javax.persistence.*;

@Entity
@Table(name = "Chairman")

public class Chairman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User user;

    public Chairman() {

    }

    public Chairman(User user) throws Exception {
        boolean isCorrect=false;
        for (UserType userType: user.types
        ) {
            if(userType.type.equals("chairman")){
                isCorrect=true;
            }
        }
        if(!isCorrect){
            throw new Exception("L'utilisateur doit être un chairman");
        }

        this.user = user;
    }
}
