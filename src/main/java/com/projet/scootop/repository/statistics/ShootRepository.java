package com.projet.scootop.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.statistics.Shoot;

@Repository
public interface ShootRepository extends JpaRepository<Shoot,Long> {

}
