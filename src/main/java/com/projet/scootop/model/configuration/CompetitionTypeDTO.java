package com.projet.scootop.model.configuration;

public class CompetitionTypeDTO {
	Long id;
    String name;

    public static CompetitionTypeDTO create(Long id, String name) {

        CompetitionTypeDTO typeDTO=new CompetitionTypeDTO();
        typeDTO.id = id;
        typeDTO.name = name;
        return typeDTO;
    }

    @Override
    public String toString() {
        return "TypeRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
