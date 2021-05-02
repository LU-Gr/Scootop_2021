package com.projet.scootop.domain.user;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Contact {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String tel;
    
    @Getter @Setter
    private String address;
    
    @Getter @Setter
    private String codePostal;
    
    @OneToOne
    @Getter @Setter
    private User user;
    
    @Getter @Setter
    private String pays;

    public Contact(String tel, String address, String cp) {
        this.tel = tel;
        this.address = address;
        this.codePostal = cp;
    }

    public Contact() {
    }

}
