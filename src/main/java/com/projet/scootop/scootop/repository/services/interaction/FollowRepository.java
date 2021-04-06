package com.projet.scootop.scootop.repository.services.interaction;


import com.projet.scootop.scootop.domain.services.interaction.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {

}
