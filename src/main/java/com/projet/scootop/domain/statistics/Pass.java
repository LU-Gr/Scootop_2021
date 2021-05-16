package com.projet.scootop.domain.statistics;

import javax.persistence.*;

import com.projet.scootop.domain.configuration.TouchType;
import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.tools.StatisticalSheet;
import com.projet.scootop.domain.user.domain.Player;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Pass")

public class Pass {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
    @Getter @Setter
    private int minute;

    @Getter @Setter
    private Boolean decisive;

    @Getter @Setter
    private Boolean isSuccess;
    
    @Getter @Setter
    private Boolean isLongPass;
    
    @ManyToOne
    @Getter @Setter
    private StatisticalSheet statisticalSheet;
    
    @ManyToOne
    @Getter @Setter
    private Player player;
    
    @ManyToOne
    @Getter @Setter
    private Match match;
    
    @ManyToOne
    @Getter @Setter
    private TouchType touchType;
    

    public Pass() {
    }

    public Pass(Match matchSheet, Player player, int minute, TouchType typeTouch, Boolean decisive, Boolean isSuccess, Boolean longPass) {
        super();
        this.match = matchSheet;
        this.minute = minute;
        this.player = player;
        this.touchType = typeTouch;
        this.decisive = decisive;
        this.isSuccess = isSuccess;
        this.isLongPass = longPass;
    }
}
