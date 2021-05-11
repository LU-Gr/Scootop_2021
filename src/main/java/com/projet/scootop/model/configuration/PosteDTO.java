package com.projet.scootop.model.configuration;

import java.util.List;

import com.projet.scootop.domain.user.domainuser.Player;
import com.projet.scootop.model.user.domainuser.PlayerDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PosteDTO {
	
	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private List<PlayerDTO> players;

}
