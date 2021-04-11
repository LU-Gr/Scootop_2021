package com.projet.scootop.model.user;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private String firstName;
	
	@Getter @Setter
    private String lastName;
    
    @Getter @Setter
    private String email;
    
    @Getter @Setter
    private String password;
    
    @Getter @Setter
    private ContactDTO contact;
    
    @Getter @Setter
    private List<UserTypeDTO> types;

}
