package com.projet.scootop.model.provider;

import com.projet.scootop.model.inprogress.MatchSheetDTO;
import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

public class AnalysteDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private UserDTO user;
	
	@Getter @Setter
	private Double tarif;
	
	@Getter @Setter
	private Integer experience;
	
	@Getter @Setter
	private MatchSheetDTO matchSheet;

}
