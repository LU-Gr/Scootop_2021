package com.projet.scootop.model.statistical;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.statistical.Pass;
import com.projet.scootop.domain.statistical.physical.TypeTouch;

public class ShootDTO {

    public Long id;
    public MatchSheet matchSheet;
    public TypeTouch typeTouch;
    public Player player;

    public Boolean inBox;
    public Boolean isGoal;
    public Boolean isLongShoot;
    public Pass assist;


    public static ShootDTO create(MatchSheet matchSheet, TypeTouch typeTouch, Player player, Boolean inBox, Boolean goal, Boolean aLong, Pass assist) {
        ShootDTO shootDTO= new ShootDTO();
        shootDTO.inBox = inBox;
        shootDTO.matchSheet = matchSheet;
        shootDTO.typeTouch = typeTouch;
        shootDTO.player = player;
        shootDTO.isGoal = goal;
        shootDTO.isLongShoot = aLong;
        shootDTO.assist = assist;

        return shootDTO;
    }
}
