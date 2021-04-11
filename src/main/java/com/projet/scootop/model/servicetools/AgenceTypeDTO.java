package com.projet.scootop.model.servicetools;

public class AgenceTypeDTO {

    int id;
    String name;

    public static AgenceTypeDTO create(int id, String name) {
        AgenceTypeDTO agencetype = new AgenceTypeDTO();
        agencetype.id = id;
        agencetype.name = name;

        return  agencetype;
    }

    @Override
    public String toString() {
        return "AgenceTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
