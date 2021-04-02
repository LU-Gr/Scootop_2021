package com.projet.scootop.scootop.model.domainconfiguration;

import java.util.List;

public class LeagueDTO {
    public int id;
    public String name;
    public List<DivisionsDTO> divisions;

    public static LeagueDTO create(int id, String name, List<DivisionsDTO> divisions) {
        LeagueDTO league = new LeagueDTO();
        league.id = id;
        league.name = name;
        league.divisions = divisions;

        return league;
    }
    public static LeagueDTO get(int id, String name, List<DivisionsDTO> divisions) {
        LeagueDTO league = new LeagueDTO();
        league.id = id;
        league.name = name;
        league.divisions = divisions;

        return league;
    }

    @Override
    public String toString() {
        return "LeagueDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", divisions=" + divisions +
                '}';
    }
}
