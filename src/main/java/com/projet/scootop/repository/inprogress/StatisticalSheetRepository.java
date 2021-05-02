package com.projet.scootop.repository.inprogress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.inprogress.StatisticalSheet;

@Repository
public interface StatisticalSheetRepository extends JpaRepository<StatisticalSheet, Long> {

	StatisticalSheet findByPlayerId(Long playerId);
    StatisticalSheet findByMatchSheet(Long gameSheet);
}
