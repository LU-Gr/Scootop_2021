package com.projet.scootop.scootop.model.domainconfiguration;

public class TypeDTO {
    int id;
    String name;

    public static TypeDTO create(int id, String name) {

        TypeDTO typeDTO=new TypeDTO();
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
