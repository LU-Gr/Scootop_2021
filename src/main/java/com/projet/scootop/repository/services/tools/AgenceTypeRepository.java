package com.projet.scootop.repository.services.tools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.tools.AgenceType;

@Repository
public interface AgenceTypeRepository extends JpaRepository<AgenceType, Long> {

}

