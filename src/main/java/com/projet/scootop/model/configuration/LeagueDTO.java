package com.projet.scootop.model.configuration;

import java.util.List;

public class LeagueDTO {
    public Long id;
    public String name;
    public List<DivisionDTO> divisions;

    public static LeagueDTO create(Long id, String name, List<DivisionDTO> divisions) {
        LeagueDTO league = new LeagueDTO();
        league.id = id;
        league.name = name;
        league.divisions = divisions;

        return league;
    }
    public static LeagueDTO get(Long id, String name, List<DivisionDTO> divisions) {
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
