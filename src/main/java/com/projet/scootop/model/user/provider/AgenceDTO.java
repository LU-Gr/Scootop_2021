package com.projet.scootop.model.user.provider;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class AgenceDTO {
	
	@Getter @Setter
    private Long id;
	
	@Getter @Setter
	private String region;
	
	@Getter @Setter
	private List<MarketingAdvisorDTO> marketingAdvisors;
	
	@Getter @Setter
	private List<ManagerDTO> manager;
}
