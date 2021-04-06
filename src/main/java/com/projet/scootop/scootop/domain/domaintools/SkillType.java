package com.projet.scootop.scootop.domain.domaintools;

import javax.persistence.*;

// type de skill (défensif, offensif, ...)
@Entity
@Table(name = "SkillType")

public class SkillType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;

    public SkillType(String name) {
        super();
        this.name = name;
    }

    public SkillType() {
    }
}
