package com.projet.scootop.domain.statistical.physical;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TYPE_SHOOT")
public class TypeTouch {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String physical;

    public TypeTouch(String physical) {
        this.physical = physical;
    }

    public TypeTouch() {
    }
}
