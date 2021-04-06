package com.projet.scootop.scootop.repository.provider;

import com.projet.scootop.scootop.domain.provider.WearableSociety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WearableSocietyRepository extends JpaRepository<WearableSociety, Long> {

}
