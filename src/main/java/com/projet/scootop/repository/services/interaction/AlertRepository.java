package com.projet.scootop.repository.services.interaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.interaction.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert,Long> {

}
