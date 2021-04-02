package com.projet.scootop.scootop.model.domainuser;

import com.projet.scootop.scootop.user.User;

public class ChairmanDTO {

    public int id;
    public User user;

    public static ChairmanDTO create( User user) {
        ChairmanDTO chairmanDTO = new ChairmanDTO();
        chairmanDTO.user = user;
        return chairmanDTO;
    }
    public static ChairmanDTO get(int id, User user) {
        ChairmanDTO chairmanDTO = new ChairmanDTO();
        chairmanDTO.id = id;
        chairmanDTO.user = user;
        return chairmanDTO;
    }

    @Override
    public String toString() {
        return "ChairmanDTO{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
