package com.projet.scootop.scootop.model.servicetools;

public class PrestationTypeDTO {

    int id;
    String name;

    public static PrestationTypeDTO create(int id, String name) {

        PrestationTypeDTO prestationtype = new PrestationTypeDTO();
        prestationtype.id = id;
        prestationtype.name = name;

        return prestationtype;
    }

    @Override
    public String toString() {
        return "PrestationTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
