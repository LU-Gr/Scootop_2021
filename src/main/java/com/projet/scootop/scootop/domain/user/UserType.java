package com.projet.scootop.scootop.domain.user;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "USER_TYPE")
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String type;
    @ManyToMany
    public List<User> users;


    public UserType(String type) {
        super();
        this.type = type;
    }

    public UserType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
