package com.projet.scootop.repository.statistical.physical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.statistical.physical.TypeTouch;

@Repository
public interface TypeTouchRepository extends JpaRepository<TypeTouch,Long> {

}
