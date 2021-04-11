package com.projet.scootop.repository.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {

}
