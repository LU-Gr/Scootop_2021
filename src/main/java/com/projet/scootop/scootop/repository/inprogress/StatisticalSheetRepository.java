package com.projet.scootop.scootop.repository.inprogress;

import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticalSheetRepository extends JpaRepository<StatisticalSheet, Long> {

    StatisticalSheet findByMatchSheet(Long gameSheet);
}
