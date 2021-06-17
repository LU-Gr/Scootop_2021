package com.projet.scootop.model.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
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
    private LocalDate birthday;
    
   // @JsonIgnore
    @Getter @Setter
    private String password;
    
    @Getter @Setter
    private ContactDTO contact;
    
    @Getter @Setter
    private List<UserTypeDTO> userTypes;

}
