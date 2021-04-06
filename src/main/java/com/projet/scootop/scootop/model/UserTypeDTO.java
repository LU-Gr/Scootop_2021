package com.projet.scootop.scootop.model;

import com.projet.scootop.scootop.domain.user.User;
import java.util.List;

public class UserTypeDTO {
    public Long id;
    public String type;
    public List<User> users;

    public static UserTypeDTO create(String type) {
        UserTypeDTO user= new UserTypeDTO();
        user.type=type;
        return user;
    }
    public static UserTypeDTO get(Long id, String type) {
        UserTypeDTO user= new UserTypeDTO();
        user.id=id;
        user.type=type;
        return user;
    }

    @Override
    public String toString() {
        return "UserTypeDTO{" +
                "id=" + id +
                ", types='" + type + '\'' +
                ", users=" + users +
                '}';
    }
}
