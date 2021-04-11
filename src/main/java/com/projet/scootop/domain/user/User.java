package com.projet.scootop.domain.user;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Table(name = "USER")
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    @Getter @Setter
    private Contact contact;
    
    @Getter @Setter
    private LocalDate birthday;
    
    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;
    
    @Column(unique=true)
    @Getter @Setter
    private String email;
    
    //TODO: encoder
    @Getter @Setter
    private String password;

    @ManyToMany
    @JoinTable(name = "USER_TYPES")
    @Getter @Setter
    private List<UserType> types;

    public User(String name, String firstName, Contact contact) {
        super();
        this.lastName = name;
        this.firstName = firstName;
        this.contact = contact;
        this.types=new ArrayList<>();
    }

    public User() {
    }

}
