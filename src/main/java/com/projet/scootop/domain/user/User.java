package com.projet.scootop.domain.user;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Table(name = "USER")
public class User {
    
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;
    
    @Column(unique=true)
    @Getter @Setter
    private String email;
    
    @Getter @Setter
    private LocalDate birthday;
    
    @JsonIgnore
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
    @JsonIgnoreProperties({"users"})
    @Getter @Setter
    private List<UserType> userTypes;

    public User(String name, String firstName, Contact contact) {
        super();
        this.lastName = name;
        this.firstName = firstName;
        this.contact = contact;
        this.userTypes=new ArrayList<>();
    }

    public User() {
    	this.contact = new Contact();
    }

}
