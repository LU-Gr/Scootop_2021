package com.projet.scootop.domain.user;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact")
public class Contact {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String email;
    
    @Getter @Setter
    private String tel;
    
    @Getter @Setter
    private String address;
    
    @Getter @Setter
    private String cp;
    
    @OneToOne
    @Getter @Setter
    private User user;

    public Contact(String email, String tel, String address, String cp) {
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.cp = cp;
    }

    public Contact() {
    }

}
