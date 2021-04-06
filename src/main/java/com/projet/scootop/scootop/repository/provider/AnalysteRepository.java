package com.projet.scootop.scootop.repository.provider;

import com.projet.scootop.scootop.domain.provider.Analyste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysteRepository extends JpaRepository<Analyste, Long> {

}
