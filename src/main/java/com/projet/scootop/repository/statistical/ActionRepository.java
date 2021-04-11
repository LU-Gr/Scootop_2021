package com.projet.scootop.repository.statistical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.statistical.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {

}
