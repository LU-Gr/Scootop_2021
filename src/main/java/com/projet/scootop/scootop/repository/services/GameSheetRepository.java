package com.projet.scootop.scootop.repository.services;

import com.projet.scootop.scootop.domain.services.GameSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSheetRepository extends JpaRepository<GameSheet,Long> {

}
