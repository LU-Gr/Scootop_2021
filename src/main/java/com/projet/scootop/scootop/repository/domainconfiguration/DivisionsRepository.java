package com.projet.scootop.scootop.repository.domainconfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projet.scootop.scootop.domain.domainconfiguration.Division;
import java.util.List;

@Repository
public interface DivisionsRepository extends JpaRepository<Division, Long> {

    public List<Division> findAllByLeagueId(Long leagueId);
}
