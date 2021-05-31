package com.projet.scootop.model.tools;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

public class SaisonDTO {

	@Getter @Setter
    private Integer id;
	
	@Getter @Setter
    private LocalDate dateDebut;
	
	@Getter @Setter
    private LocalDate dateFin;
	
	@Getter @Setter
	@JsonIgnoreProperties("saison")
    private List<MatchDTO> matchs;

}
