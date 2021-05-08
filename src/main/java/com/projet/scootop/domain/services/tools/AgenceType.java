package com.projet.scootop.domain.services.tools;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AgenceType")
public class AgenceType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;
    
    @Getter @Setter
    private String Name;

    public AgenceType(int id, String name) {
        this.id = id;
        Name = name;
    }

    public AgenceType() {
    }
}
