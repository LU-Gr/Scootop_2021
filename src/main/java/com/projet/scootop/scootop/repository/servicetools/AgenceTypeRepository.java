package com.projet.scootop.scootop.repository.servicetools;

import com.projet.scootop.scootop.domain.servicetools.AgenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceTypeRepository extends JpaRepository<AgenceType, Long> {

}

