package com.projet.scootop.repository.tools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.tools.StatisticalSheet;

@Repository
public interface StatisticalSheetRepository extends JpaRepository<StatisticalSheet, Long> {

	StatisticalSheet findByPlayerId(Long playerId);
    StatisticalSheet findByMatch(Long gameSheet);
    StatisticalSheet findByPlayerIdAndEventId(Long playerId, Long eventId);
}
