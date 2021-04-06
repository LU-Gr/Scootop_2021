package com.projet.scootop.scootop.repository.statistical.physical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projet.scootop.scootop.domain.stastistical.physical.PlayerHead;

@Repository
public interface PlayerHeadRepository extends JpaRepository<PlayerHead,Long> {

}
