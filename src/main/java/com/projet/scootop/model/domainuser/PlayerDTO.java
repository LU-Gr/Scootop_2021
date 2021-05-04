package com.projet.scootop.model.domainuser;

import java.util.List;

import com.projet.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.model.domainconfiguration.MatchSheetDTO;
import com.projet.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.model.servicetools.video.VideoDTO;
import com.projet.scootop.model.statistical.StatisticalSheetDTO;
import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

public class PlayerDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private CategoryDTO category;
	
	@Getter @Setter
    private int rating;
	
	@Getter @Setter
    private int taille;
	
	@Getter @Setter
    private int poids;
	
	@Getter @Setter
    private int vma;
	
	@Getter @Setter
    private String nationalite;
	
	@Getter @Setter
    private String origin;
	
	@Getter @Setter
    private int interaction;
	
	@Getter @Setter
    private String strongFoot;
	
	@Getter @Setter
    private String weekFoot;
	
	@Getter @Setter
    private UserDTO user;
	
	@Getter @Setter
    private List<TeamDTO> teams;
	
	@Getter @Setter
    private List<StatisticalSheetDTO> statisticalSheets;
	
	@Getter @Setter
    private List<MatchSheetDTO> matshSheets;
	
	@Getter @Setter
    private List<VideoDTO> videos;
}
