package com.projet.scootop.repository.servicetools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.servicetools.AgenceType;

@Repository
public interface AgenceTypeRepository extends JpaRepository<AgenceType, Long> {

}

