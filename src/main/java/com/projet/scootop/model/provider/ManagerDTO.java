package com.projet.scootop.model.provider;

import com.projet.scootop.domain.provider.Agence;


public class ManagerDTO {

    public Long id;
    public String name;
    public Agence agence;

    public static ManagerDTO create(String name, Agence agence) {
        ManagerDTO managerDTO= new ManagerDTO();
        managerDTO.name = name;
        managerDTO.agence = agence;
        return managerDTO;
    }
    public static ManagerDTO get(Long id, String name, Agence agence) {
        ManagerDTO managerDTO= new ManagerDTO();
        managerDTO.id = id;
        managerDTO.name = name;
        managerDTO.agence = agence;
        return managerDTO;
    }

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
