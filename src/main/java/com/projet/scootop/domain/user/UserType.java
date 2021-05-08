package com.projet.scootop.domain.user;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "USER_TYPE")
public class UserType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String type;
    
    @ManyToMany
    @JoinTable(name = "user_user_type", 
   	joinColumns = @JoinColumn(name = "user_type_id", referencedColumnName = "id"),
   	inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @Getter @Setter
    private List<User> users;


    public UserType(String type) {
        super();
        this.type = type;
    }

    public UserType() {
    }

}
