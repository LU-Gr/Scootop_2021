package com.projet.scootop.repository.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.configuration.ActionType;

@Repository
public interface ActionTypeRepository extends JpaRepository<ActionType, Long> {

}

