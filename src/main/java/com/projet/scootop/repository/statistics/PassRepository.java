package com.projet.scootop.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.statistics.Pass;

@Repository
public interface PassRepository extends JpaRepository<Pass,Long> {

}
