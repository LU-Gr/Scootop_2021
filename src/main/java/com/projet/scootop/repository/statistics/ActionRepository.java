package com.projet.scootop.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.statistics.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {

}
