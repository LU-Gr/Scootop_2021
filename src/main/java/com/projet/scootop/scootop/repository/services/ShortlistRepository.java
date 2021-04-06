package com.projet.scootop.scootop.repository.services;

import com.projet.scootop.scootop.domain.services.Shortlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortlistRepository extends JpaRepository<Shortlist,Long> {

}
