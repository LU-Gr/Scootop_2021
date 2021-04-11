package com.projet.scootop.model.services.interaction;

import java.time.LocalDate;

import com.projet.scootop.domain.domaintools.Saison;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.services.Events;
import com.projet.scootop.domain.user.User;

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
