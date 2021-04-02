package com.projet.scootop.scootop.model.domainconfiguration;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.model.ContactDTO;
import com.projet.scootop.scootop.user.Contact;

import java.util.List;

public class StadeDTO {
    public int id;
    public String name;
    public Contact contact;

    public static StadeDTO create(Integer id,String name, Contact contact) {

        StadeDTO stadeDTO =new StadeDTO();
        stadeDTO.id = id;
        stadeDTO.name = name;
        stadeDTO.contact = contact;
        return stadeDTO;

    }

    public static StadeDTO get(Integer id,String name, Contact contact) {

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
