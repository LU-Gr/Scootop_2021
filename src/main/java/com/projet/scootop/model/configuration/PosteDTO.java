package com.projet.scootop.model.configuration;

import java.util.List;

import com.projet.scootop.domain.user.domainuser.Player;

public class PosteDTO {
    public Long id;
    public String name;
    public List<Player> playerList;

    public static PosteDTO create(Long id, String name, List<Player> playerList) {
        PosteDTO posteDTO=new PosteDTO();
        posteDTO.id = id;
        posteDTO.name = name;
        posteDTO.playerList = playerList;
        return posteDTO;

    }
    public static PosteDTO get(Long id, String name, List<Player> playerList) {
        PosteDTO posteDTO=new PosteDTO();
        posteDTO.id = id;
        posteDTO.name = name;
        posteDTO.playerList = playerList;
        return posteDTO;

    }

    @Override
    public String toString() {
        return "PosteRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';

    }
}
