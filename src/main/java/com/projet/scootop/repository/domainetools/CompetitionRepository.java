package com.projet.scootop.repository.domainetools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.domaintools.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

}
