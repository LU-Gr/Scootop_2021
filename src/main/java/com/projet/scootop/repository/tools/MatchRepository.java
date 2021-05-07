package com.projet.scootop.repository.tools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.tools.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
