package com.projet.scootop.scootop.repository.statistical;

import com.projet.scootop.scootop.domain.stastistical.Goal;
import com.projet.scootop.scootop.model.statistical.GoalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Integer> {

}
