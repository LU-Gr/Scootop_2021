package com.projet.scootop.scootop.repository.domainconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League,Long> {

}
