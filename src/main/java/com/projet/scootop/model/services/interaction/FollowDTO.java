package com.projet.scootop.model.services.interaction;


import java.time.LocalDate;

import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.user.User;

public class FollowDTO {

	Long id;
    public LocalDate dateCreated;
    public User user;
    public Player player;
    public Saison saison;

    public static FollowDTO create(LocalDate dateCreated, User user, Player player, Saison saison) {
        FollowDTO followDTO = new FollowDTO();
        followDTO.dateCreated = dateCreated;
        followDTO.user = user;
        followDTO.player = player;
        followDTO.saison = saison;
        return followDTO;
    }
    public static FollowDTO get(Long id, LocalDate dateCreated, User user, Player player, Saison saison) {
        FollowDTO followDTO = new FollowDTO();
        followDTO.id = id;
        followDTO.dateCreated = dateCreated;
        followDTO.user = user;
        followDTO.player = player;
        followDTO.saison = saison;
        return followDTO;
    }

    @Override
    public String toString() {
        return "FollowDTO{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", user=" + user +
                ", players=" + player +
                ", saison=" + saison +
                '}';
    }
}
