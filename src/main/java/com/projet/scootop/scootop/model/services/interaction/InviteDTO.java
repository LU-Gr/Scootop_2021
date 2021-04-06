package com.projet.scootop.scootop.model.services.interaction;

import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.user.User;

import java.time.LocalDate;

public class InviteDTO {

    public Long id;
    public Saison saison;
    public Events events;
    public User user;
    public Player player;
    public LocalDate createAt;
    public boolean response;

    public  static InviteDTO create(Saison saison, Events events, User user, Player player, LocalDate createAt, boolean response) {
        InviteDTO invite = new InviteDTO();
        invite.saison = saison;
        invite.events = events;
        invite.user = user;
        invite.player = player;
        invite.createAt = createAt;
        invite.response = response;
        return invite;
    }
    public  static InviteDTO get(Long id, Saison saison, Events events, User user, Player player, LocalDate createAt, boolean response) {
        InviteDTO invite = new InviteDTO();
        invite.id = id;
        invite.saison = saison;
        invite.events = events;
        invite.user = user;
        invite.player = player;
        invite.createAt = createAt;
        invite.response = response;
        return invite;
    }
}
