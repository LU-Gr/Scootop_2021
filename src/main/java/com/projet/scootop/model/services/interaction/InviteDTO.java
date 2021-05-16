package com.projet.scootop.model.services.interaction;

import java.time.LocalDate;

import com.projet.scootop.model.services.EventDTO;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.model.user.UserDTO;
import com.projet.scootop.model.user.domain.PlayerDTO;

import lombok.Getter;
import lombok.Setter;

public class InviteDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private LocalDate createAt;
    
    @Getter @Setter
    private boolean response;
	
	@Getter @Setter
	private SaisonDTO saison;
    
    @Getter @Setter
    private EventDTO events;
    
    @Getter @Setter
    private UserDTO user;
    
    @Getter @Setter
    private PlayerDTO player;
    
    

   
}
