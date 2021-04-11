package com.projet.scootop.repository.statistical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.statistical.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {

}