package com.projet.scootop.scootop.model.provider;

import com.projet.scootop.scootop.user.Contact;

public class WearableSocietyDTO {
    public Integer id;
    public String name;
    public String societe;
    public String ceo;
    public String specialite;
    public Integer tarif;
    public Contact contact;


    public static WearableSocietyDTO create( String name, String societe, String ceo, String specialite, Integer tarif, Contact contact) {
        WearableSocietyDTO wearableSocietyDTO=new WearableSocietyDTO();
        wearableSocietyDTO.name = name;
        wearableSocietyDTO.societe = societe;
        wearableSocietyDTO.ceo = ceo;
        wearableSocietyDTO.specialite = specialite;
        wearableSocietyDTO.tarif = tarif;
        wearableSocietyDTO.contact = contact;
        return wearableSocietyDTO;
    }
    public static WearableSocietyDTO get(Integer id, String name, String societe, String ceo, String specialite, Integer tarif, Contact contact) {
        WearableSocietyDTO wearableSocietyDTO=new WearableSocietyDTO();

        wearableSocietyDTO.id = id;
        wearableSocietyDTO.name = name;
        wearableSocietyDTO.societe = societe;
        wearableSocietyDTO.ceo = ceo;
        wearableSocietyDTO.specialite = specialite;
        wearableSocietyDTO.tarif = tarif;
        wearableSocietyDTO.contact = contact;

        return wearableSocietyDTO;
    }


    @Override
    public String toString() {
        return "WearableSocietyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
