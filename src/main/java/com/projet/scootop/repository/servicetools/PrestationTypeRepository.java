package com.projet.scootop.repository.servicetools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.servicetools.PrestationType;

@Repository
public interface PrestationTypeRepository extends JpaRepository<PrestationType, Long> {

}

