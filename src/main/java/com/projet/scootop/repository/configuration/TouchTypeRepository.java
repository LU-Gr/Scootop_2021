package com.projet.scootop.repository.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.configuration.TouchType;

@Repository
public interface TouchTypeRepository extends JpaRepository<TouchType,Long> {

}
