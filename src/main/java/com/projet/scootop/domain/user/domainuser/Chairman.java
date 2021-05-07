package com.projet.scootop.domain.user.domainuser;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;

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
        for (UserType userType: user.getTypes()) {
            if(userType.getType().equals("chairman")){
                isCorrect=true;
            }
        }
        if(!isCorrect){
            throw new Exception("L'utilisateur doit être un chairman");
        }

        this.user = user;
    }
}
