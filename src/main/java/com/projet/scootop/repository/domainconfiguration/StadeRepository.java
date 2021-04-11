package com.projet.scootop.repository.domainconfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.domainconfiguration.Stade;

@Repository

public interface StadeRepository extends JpaRepository<Stade,Long> {

}
