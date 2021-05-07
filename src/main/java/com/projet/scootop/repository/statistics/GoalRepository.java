package com.projet.scootop.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.statistics.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {

}
