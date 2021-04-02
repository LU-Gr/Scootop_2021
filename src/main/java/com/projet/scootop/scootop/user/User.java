package com.projet.scootop.scootop.user;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @OneToOne
    @JoinColumn(name = "CONTACT_ID")
    public Contact contact;
    public Double rating;

    public String name;
    public String firstName;

    @ManyToMany
    @JoinTable(name = "USER_TYPES")
    public List<UserType> types;

    public User(String name, String firstName, Contact contact) {
        super();
        this.name = name;
        this.firstName = firstName;
        this.contact = contact;
        this.rating=0.0;
        this.types=new ArrayList<>();
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<UserType> getTypes() {
        return types;
    }

    public void setTypes(List<UserType> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                // ", contact=" + contact +
                // ", types=" + types +
                '}';
    }

}
