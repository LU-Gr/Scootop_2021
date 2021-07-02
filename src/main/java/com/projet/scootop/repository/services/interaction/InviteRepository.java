package com.projet.scootop.repository.services.interaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.interaction.Invite;
import com.projet.scootop.domain.user.User;

@Repository
public interface InviteRepository extends JpaRepository<Invite,Long> {
	
	List<Invite> findAllByUserId(Long id);

}
