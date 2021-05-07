package com.projet.scootop.model.user.domainuser;

import java.util.List;

import com.projet.scootop.model.configuration.CategoryDTO;
import com.projet.scootop.model.services.tools.video.VideoDTO;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.model.tools.TeamDTO;
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
    private List<MatchDTO> matshSheets;
	
	@Getter @Setter
    private List<VideoDTO> videos;
}
