package com.projet.scootop.repository.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.configuration.Division;

import java.util.List;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {

    public List<Division> findAllByLeagueId(Long leagueId);
}
