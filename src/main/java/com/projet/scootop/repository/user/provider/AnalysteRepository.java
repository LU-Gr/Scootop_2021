package com.projet.scootop.repository.user.provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.user.provider.Analyst;

@Repository
public interface AnalysteRepository extends JpaRepository<Analyst, Long> {

}
