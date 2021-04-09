package com.projet.scootop.scootop.domain.domainuser;

import com.projet.scootop.scootop.domain.user.User;
import com.projet.scootop.scootop.domain.user.UserType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Chairman")

public class Chairman {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @OneToOne
    @JoinColumn
    @Getter @Setter
    private User user;

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
