package com.projet.scootop.model.domaintools;

import java.time.LocalDate;
import java.time.Period;

import lombok.Getter;
import lombok.Setter;

public class CategoryTypeDTO {

	@Getter @Setter
    private Integer id;
	@Getter @Setter
    private int ageMin;
	@Getter @Setter
    private int ageMax;
	@Getter @Setter
    private LocalDate dateAgeMax;

    public static CategoryTypeDTO create(LocalDate dateAgeMax) {
        CategoryTypeDTO categoryTypeDTO= new CategoryTypeDTO();

        categoryTypeDTO.ageMax = categoryTypeDTO.CategoryCalcul(dateAgeMax);
        categoryTypeDTO.ageMin = categoryTypeDTO.ageMax - 5;

        categoryTypeDTO.dateAgeMax = dateAgeMax;
        return categoryTypeDTO;
    }
    public static CategoryTypeDTO get(Integer id, int ageMin, int ageMax, LocalDate dateAgeMax) {
        CategoryTypeDTO categoryTypeDTO= new CategoryTypeDTO();
        categoryTypeDTO.id = id;
        categoryTypeDTO.ageMin = ageMin;
        categoryTypeDTO.ageMax = ageMax;
        categoryTypeDTO.dateAgeMax = dateAgeMax;
        return categoryTypeDTO;
    }
    public int CategoryCalcul(LocalDate ageMax) {
        //validate inputs ...
        LocalDate currentDate= LocalDate.now();
        return Period.between(ageMax, currentDate).getYears();
    }

    @Override
    public String toString() {
        return "CategoryTypeDTO{" +
                "id=" + id +
                ", ageMin=" + ageMin +
                ", ageMax=" + ageMax +
                ", dateAgeMax=" + dateAgeMax +
                '}';
    }
}
