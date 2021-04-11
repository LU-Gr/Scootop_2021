package com.projet.scootop.model.statistical;

import java.time.LocalDate;

import com.projet.scootop.domain.statistical.Shoot;

public class GoalDTO {

	Long id;
    public LocalDate date;
    public Shoot shoot;
    public String tag;
    public Integer distance;
    public Integer rating;

    public static GoalDTO create(LocalDate date, Shoot shoot, String tag, Integer distance, Integer rating) {
        GoalDTO goalDTO = new GoalDTO();
        goalDTO.date = date;
        goalDTO.shoot = shoot;
        goalDTO.tag = tag;
        goalDTO.distance = distance;
        goalDTO.rating = rating;
        return goalDTO;
    }

}
