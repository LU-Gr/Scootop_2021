package com.projet.scootop.scootop.model.user;

import com.projet.scootop.scootop.domain.user.Contact;
import com.projet.scootop.scootop.domain.user.UserType;

import java.util.List;

public class UserDTO {
    public Long id;
    public String name;
    public String firstName;
    public Contact contact;
    public List<UserType> types;
    public Double rating;

    public static UserDTO create(String name, String firstName, Contact contact, List<UserType> types, Double rating) {
        UserDTO user= new UserDTO();
        user.contact=contact;
        user.firstName=firstName;
        user.name=name;
        user.types=types;
        user.rating=rating;
        return user;
    }
    public static UserDTO get(Long id,String name, String firstName, Contact contact,List<UserType> types,Double rating) {
        UserDTO user= new UserDTO();
        user.id=id;
        user.contact=contact;
        user.firstName=firstName;
        user.name=name;
        user.types=types;
        user.rating=rating;
        return user;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", contact=" + contact +
                ", types=" + types +
                ", rating=" + rating +
                '}';
    }
}
