package com.projet.scootop.scootop.model.domainetools;

import java.time.LocalDate;
import java.time.Period;

public class CategoryTypeDTO {

    public Integer id;
    public String name;
    public int ageMin;
    public int ageMax;
    public LocalDate dateAgeMax;

    public static CategoryTypeDTO create( String name,  LocalDate dateAgeMax) {
        CategoryTypeDTO categoryTypeDTO= new CategoryTypeDTO();
        categoryTypeDTO.name = name;

        categoryTypeDTO.ageMax = categoryTypeDTO.CategoryCalcul(dateAgeMax);
        categoryTypeDTO.ageMin = categoryTypeDTO.ageMax - 5;

        categoryTypeDTO.dateAgeMax = dateAgeMax;
        return categoryTypeDTO;
    }
    public static CategoryTypeDTO get(Integer id, String name, int ageMin, int ageMax, LocalDate dateAgeMax) {
        CategoryTypeDTO categoryTypeDTO= new CategoryTypeDTO();
        categoryTypeDTO.id = id;
        categoryTypeDTO.name = name;
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
                ", name='" + name + '\'' +
                ", ageMin=" + ageMin +
                ", ageMax=" + ageMax +
                ", dateAgeMax=" + dateAgeMax +
                '}';
    }
}
