package com.projet.scootop.model.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private String nationalite;
	
	@Getter @Setter
    private String origin;
    
    @Getter @Setter
    private String gender;
    
    @Getter @Setter
    private LocalDate birthday;
    
   // @JsonIgnore
    @Getter @Setter
    private String password;
    
    @Getter @Setter
    private ContactDTO contact;
    
    @Getter @Setter
    @JsonIgnoreProperties({"users"})
    private List<UserTypeDTO> userTypes;

}
