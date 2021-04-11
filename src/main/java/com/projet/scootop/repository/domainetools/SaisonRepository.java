package com.projet.scootop.repository.domainetools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.domaintools.Saison;

@Repository
public interface SaisonRepository extends JpaRepository<Saison, Long> {

}
