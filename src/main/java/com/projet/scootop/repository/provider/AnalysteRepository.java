package com.projet.scootop.repository.provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.provider.Analyste;

@Repository
public interface AnalysteRepository extends JpaRepository<Analyste, Long> {

}
