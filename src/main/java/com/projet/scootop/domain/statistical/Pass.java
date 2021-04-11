package com.projet.scootop.domain.statistical;

import javax.persistence.*;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.statistical.physical.TypeTouch;

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
    private MatchSheet matchSheet;
    
    @Getter @Setter
    private LocalDate date;

    @OneToOne
    @Getter @Setter
    private Player player;
    
    @OneToOne
    @Getter @Setter
    private TypeTouch typeTouch;

    @Getter @Setter
    private Boolean decisive;

    @Getter @Setter
    private Boolean isSuccess;
    
    @Getter @Setter
    private Boolean longPass;


    public Pass() {
    }

    public Pass(MatchSheet matchSheet, Player player,LocalDate date, TypeTouch typeTouch, Boolean decisive, Boolean isSuccess, Boolean longPass) {
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
