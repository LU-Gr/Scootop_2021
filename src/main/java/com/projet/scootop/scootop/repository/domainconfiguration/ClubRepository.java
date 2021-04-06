package com.projet.scootop.scootop.repository.domainconfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domainconfiguration.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

}
