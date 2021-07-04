package com.projet.scootop.model.user;

import lombok.Getter;
import lombok.Setter;

public class RegisterDTO {

	@Getter @Setter
	private String firstName;

	@Getter @Setter
	private String lastName;
	
	@Getter @Setter
	private String phoneNumber;

	@Getter @Setter
	private String email;

	@Getter @Setter
	private String password;

	@Getter @Setter
	private String birthDate;

	@Getter @Setter
	private String gender;

	@Getter @Setter
	private String nationalityCountry;

	@Getter @Setter
	private String originCountry;
}
