package com.projet.scootop.scootop.repository.domainconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

}