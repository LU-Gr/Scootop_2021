package com.projet.scootop.model.statistical;

import java.time.LocalDate;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.statistical.physical.TypeTouch;

public class PassDTO {

    public Long id;
    public MatchSheet matchSheet;
    public Player player;
    public TypeTouch typeTouch;
    public LocalDate date;

    public Boolean decisive;
    public Boolean successAssist;
    public Boolean longPass;


    public static PassDTO create(MatchSheet matchSheet, Player player,LocalDate date, TypeTouch typeTouch, Boolean decisive, Boolean successAssist, Boolean longPass) {
        PassDTO assistDTO= new PassDTO();
        assistDTO.matchSheet = matchSheet;
        assistDTO.date = date;
        assistDTO.player = player;
        assistDTO.typeTouch = typeTouch;
        assistDTO.decisive = decisive;
        assistDTO.successAssist = successAssist;
        assistDTO.longPass = longPass;
        return assistDTO;

    }
}
