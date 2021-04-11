package com.projet.scootop.repository.domainconfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.domainconfiguration.CompetitionType;

@Repository
public interface CompetitionTypeRepository extends JpaRepository<CompetitionType,Long> {

}