package com.projet.scootop.model.user;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class UserTypeDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private String type;
	
	@Getter @Setter
    private List<UserDTO> users;

}
