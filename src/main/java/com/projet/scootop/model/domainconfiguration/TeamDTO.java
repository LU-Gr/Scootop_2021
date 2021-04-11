package com.projet.scootop.model.domainconfiguration;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.domain.domainuser.Coach;
import com.projet.scootop.domain.domainuser.Player;

public class TeamDTO {

	@Getter @Setter
    private Long id;
	@Getter @Setter
	private Club club;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private List<Coach> coaches;
	@Getter @Setter
	private List<Player> players;
	@Getter @Setter
	private Category category;
	
	public TeamDTO() {
		
	}
	
	public TeamDTO(Long id, Club club, String name, List<Coach> coaches, List<Player> players, Category category) {
		this.id = id;
		this.club = club;
		this.name = name;
		this.coaches = coaches;
		this.players = players;
		this.category = category;
	}

    public static TeamDTO create(Club club, String name, List<Coach> coaches, List<Player> players, Category category) {
        TeamDTO teamDTO= new TeamDTO();
        teamDTO.club = club;
        teamDTO.name = name;
        teamDTO.coaches = coaches;
        teamDTO.players = players;
        teamDTO.category = category;

        return teamDTO;
    }
    public  static TeamDTO get(Long id, Club club, String name, List<Coach> coaches, List<Player> players, Category category) {
        TeamDTO teamDTO= new TeamDTO();
        teamDTO.id = id;
        teamDTO.club = club;
        teamDTO.name = name;
        teamDTO.coaches = coaches;
        teamDTO.players = players;
        teamDTO.category = category;

        return teamDTO;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id=" + id +
                ", club=" + club +
                ", name='" + name + '\'' +
                ", coaches=" + coaches +
                ", players=" + players +
                ", category=" + category +
                '}';
    }
}