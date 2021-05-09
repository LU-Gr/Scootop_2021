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

    @Getter @Setter
    private LocalDate birthday;
    
    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;
    
    @Column(unique=true)
    @Getter @Setter
    private String email;
    
    @Getter @Setter
    private String password;
    
    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    @Getter @Setter
    private Contact contact;
    
    @ManyToMany
    @JoinTable(name = "user_user_type", 
   	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
   	inverseJoinColumns = @JoinColumn(name = "user_type_id", referencedColumnName = "id"))
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
