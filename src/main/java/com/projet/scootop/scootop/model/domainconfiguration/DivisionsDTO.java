package com.projet.scootop.scootop.model.domainconfiguration;

public class DivisionsDTO {
    public Long id;
    public String name;

    public static DivisionsDTO create(String name) {

        DivisionsDTO divisions = new DivisionsDTO();
        divisions.name = name;
        return divisions;
    }
    public static DivisionsDTO get(Long id, String name) {

        DivisionsDTO divisions = new DivisionsDTO();
        divisions.id = id;
        divisions.name = name;
        return divisions;
    }

    @Override
    public String toString() {
        return "DivisionsRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
