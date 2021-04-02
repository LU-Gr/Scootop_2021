package com.projet.scootop.scootop.model.statistical;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;

public class SkillDTO {

    public int id;
    public String name;
    public MatchSheet matchSheet;
    public Player player;
    public Boolean isDefensive;
    public Boolean successSkill;
    public Boolean isLong;

    public static SkillDTO create(String name, MatchSheet matchSheet, Player player, Boolean isDefensive, Boolean successSkill, Boolean isLong) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.name = name;
        skillDTO.matchSheet = matchSheet;
        skillDTO.player = player;
        skillDTO.isDefensive = isDefensive;
        skillDTO.successSkill = successSkill;
        skillDTO.isLong = isLong;
        return skillDTO;
    }
    public static SkillDTO get(int id, String name, MatchSheet matchSheet, Player player, Boolean isDefensive, Boolean successSkill, Boolean isLong) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.id = id;
        skillDTO.name = name;
        skillDTO.matchSheet = matchSheet;
        skillDTO.player = player;
        skillDTO.isDefensive = isDefensive;
        skillDTO.successSkill = successSkill;
        skillDTO.isLong = isLong;
        return skillDTO;
    }

    @Override
    public String toString() {
        return "SkillRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
