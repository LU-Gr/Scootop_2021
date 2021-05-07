package com.projet.scootop.repository.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.configuration.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long> {

}
