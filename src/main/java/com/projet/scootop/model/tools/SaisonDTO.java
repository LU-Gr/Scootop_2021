package com.projet.scootop.model.tools;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import com.projet.scootop.model.configuration.LeagueDTO;

public class SaisonDTO {

	@Getter @Setter
    private Integer id;
	
	@Getter @Setter
    private LocalDate dateDebut;
	
	@Getter @Setter
    private LocalDate dateFin;
	
	@Getter @Setter
    private LeagueDTO league;
	
	@Getter @Setter
    private List<MatchDTO> matchs;

}
