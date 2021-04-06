package com.projet.scootop.scootop.repository.inprogress;

import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchSheetRepository extends JpaRepository<MatchSheet, Long> {

}
