package com.projet.scootop.scootop.model.statistical;

import java.time.LocalDate;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.domain.stastistical.physical.TypeTouch;

public class AssistDTO {

    public int id;
    public MatchSheet matchSheet;
    public Player player;
    public TypeTouch typeTouch;
    public LocalDate date;

    public Boolean decisive;
    public Boolean successAssist;
    public Boolean longPass;


    public static AssistDTO create(MatchSheet matchSheet, Player player,LocalDate date, TypeTouch typeTouch, Boolean decisive, Boolean successAssist, Boolean longPass) {
        AssistDTO assistDTO= new AssistDTO();
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
