package com.projet.scootop.domain.domaintools;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

// type de skill (défensif, offensif, ...)
@Entity
@Table(name = "SkillType")

public class SkillType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private String name;

    public SkillType(String name) {
        super();
        this.name = name;
    }

    public SkillType() {
    }
}
