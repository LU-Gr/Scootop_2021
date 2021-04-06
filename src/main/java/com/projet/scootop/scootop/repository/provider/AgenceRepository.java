package com.projet.scootop.scootop.repository.provider;

import com.projet.scootop.scootop.domain.provider.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {

}
