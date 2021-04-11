package com.projet.scootop.repository.services.interaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.interaction.Invite;

@Repository
public interface InviteRepository extends JpaRepository<Invite,Long> {

}
