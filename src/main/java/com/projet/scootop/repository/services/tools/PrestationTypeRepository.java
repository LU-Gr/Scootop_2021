package com.projet.scootop.repository.services.tools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.tools.PrestationType;

@Repository
public interface PrestationTypeRepository extends JpaRepository<PrestationType, Long> {

}

