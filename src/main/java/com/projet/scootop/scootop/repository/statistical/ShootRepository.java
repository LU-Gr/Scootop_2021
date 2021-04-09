package com.projet.scootop.scootop.repository.statistical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.statistical.Shoot;

@Repository
public interface ShootRepository extends JpaRepository<Shoot,Long> {

}
