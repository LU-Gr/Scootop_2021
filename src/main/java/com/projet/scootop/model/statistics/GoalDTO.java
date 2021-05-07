package com.projet.scootop.model.statistics;

import java.time.LocalDate;

import com.projet.scootop.domain.statistics.Shoot;

import lombok.Getter;
import lombok.Setter;

public class GoalDTO {

	@Getter @Setter
	private Long id;
	
	@Getter @Setter
	private LocalDate date;
	
	@Getter @Setter
	private Shoot shoot;
	
	@Getter @Setter
	private String tag;
	
	@Getter @Setter
	private Integer distance;
	
	@Getter @Setter
	private Integer rating;

}
