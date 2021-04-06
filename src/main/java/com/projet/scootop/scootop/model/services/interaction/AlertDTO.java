package com.projet.scootop.scootop.model.services.interaction;

import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.user.User;

import java.time.LocalDate;

public class AlertDTO {
	Long id;
    public LocalDate dateCreated;
    public User user;
    public Player player;
    public Saison saison;

    public static AlertDTO create(LocalDate dateCreated, User user, Player player, Saison saison) {
        AlertDTO alertDTO = new AlertDTO();
        alertDTO.dateCreated = dateCreated;
        alertDTO.user = user;
        alertDTO.player = player;
        alertDTO.saison = saison;
        return alertDTO;
    }
    public static AlertDTO get(Long id, LocalDate dateCreated, User user, Player player, Saison saison) {
        AlertDTO alertDTO = new AlertDTO();
        alertDTO.id = id;
        alertDTO.dateCreated = dateCreated;
        alertDTO.user = user;
        alertDTO.player = player;
        alertDTO.saison = saison;
        return alertDTO;
    }

    @Override
    public String toString() {
        return "AlertDTO{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", user=" + user +
                ", players=" + player +
                ", saison=" + saison +
                '}';
    }
}
