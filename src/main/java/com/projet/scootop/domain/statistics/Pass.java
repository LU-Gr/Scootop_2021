package com.projet.scootop.domain.statistics;

import javax.persistence.*;

import com.projet.scootop.domain.configuration.TouchType;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.user.domainuser.Player;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Pass")

public class Pass {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @Getter @Setter
    private Match matchSheet;
    
    @Getter @Setter
    private LocalDate date;

    @OneToOne
    @Getter @Setter
    private Player player;
    
    @OneToOne
    @Getter @Setter
    private TouchType typeTouch;

    @Getter @Setter
    private Boolean decisive;

    @Getter @Setter
    private Boolean isSuccess;
    
    @Getter @Setter
    private Boolean longPass;


    public Pass() {
    }

    public Pass(Match matchSheet, Player player,LocalDate date, TouchType typeTouch, Boolean decisive, Boolean isSuccess, Boolean longPass) {
        super();
        this.matchSheet = matchSheet;
        this.date = date;
        this.player = player;
        this.typeTouch = typeTouch;
        this.decisive = decisive;
        this.isSuccess = isSuccess;
        this.longPass = longPass;
    }
}
