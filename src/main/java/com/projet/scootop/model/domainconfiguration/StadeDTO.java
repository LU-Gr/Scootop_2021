package com.projet.scootop.model.domainconfiguration;

import com.projet.scootop.domain.user.Contact;

public class StadeDTO {
    public Long id;
    public String name;
    public Contact contact;

    public static StadeDTO create(Long id,String name, Contact contact) {

        StadeDTO stadeDTO =new StadeDTO();
        stadeDTO.id = id;
        stadeDTO.name = name;
        stadeDTO.contact = contact;
        return stadeDTO;

    }

    public static StadeDTO get(Long id,String name, Contact contact) {

        StadeDTO stadeDTO=new StadeDTO();
        stadeDTO.id = id;
        stadeDTO.name = name;
        stadeDTO.contact = contact;
        return stadeDTO;

    }


    @Override
    public String toString() {
        return "StadeRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +

                '}';
    }
}
