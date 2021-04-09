package com.projet.scootop.scootop.repository.inprogress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.inprogress.StatisticalSheet;

@Repository
public interface StatisticalSheetRepository extends JpaRepository<StatisticalSheet, Long> {

    StatisticalSheet findByMatchSheet(Long gameSheet);
}
