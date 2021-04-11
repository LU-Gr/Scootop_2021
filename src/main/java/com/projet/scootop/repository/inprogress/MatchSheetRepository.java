package com.projet.scootop.repository.inprogress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.inprogress.MatchSheet;

@Repository
public interface MatchSheetRepository extends JpaRepository<MatchSheet, Long> {

}
