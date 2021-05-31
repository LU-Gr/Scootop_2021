package com.projet.scootop.model.user.provider;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AgenceDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String region;
	
	@Getter @Setter
	@JsonIgnoreProperties("agence")
	private List<MarketingAdvisorDTO> marketingAdvisors;
	
	@Getter @Setter
	@JsonIgnoreProperties("agence")
	private List<ManagerDTO> manager;
}
