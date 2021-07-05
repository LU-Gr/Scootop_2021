package com.projet.scootop.model.user.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.model.configuration.CategoryDTO;
import com.projet.scootop.model.configuration.PosteDTO;
import com.projet.scootop.model.services.tools.video.VideoDTO;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.model.user.UserDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PlayerDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private int rating;
	
	@Getter @Setter
    private int taille;
	
	@Getter @Setter
    private int poids;
	
	@Getter @Setter
    private int vma;
	
	@Getter @Setter
    private boolean isSelected;
    
    @Getter @Setter
    private boolean isSubstitute;
	
	@Getter @Setter
    private int interaction;
	
	@Getter @Setter
    private String strongFoot;
	
	@Getter @Setter
    private String weekFoot;
	
	@Getter @Setter
    private String photoUrl;
	
	@Getter @Setter
    private UserDTO user;
	
	@Getter @Setter
    private CategoryDTO category;
	
	@Getter @Setter
	@JsonIgnoreProperties({"player"})
    private List<StatisticalSheetDTO> statisticalSheets;
	
	@Getter @Setter
	@JsonIgnoreProperties("player")
    private List<VideoDTO> videos;

	@Getter @Setter
	@JsonIgnoreProperties(value={"players"}, allowSetters = true)
	private List<TeamDTO> teams;

	@Getter @Setter
	@JsonIgnoreProperties(value={"players"}, allowSetters = true)
	private List<PosteDTO> postes;
	
}
