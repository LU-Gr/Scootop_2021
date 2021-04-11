package com.projet.scootop.repository.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.Wearable;

import java.util.List;

@Repository
public interface WearableRepository extends JpaRepository<Wearable,Long> {


    List<Wearable> findAllById(Long numbers);
    List<Wearable> findAllByTeam(Long team);
    List<Wearable> findAllByMatchSheetAndTeam(Long gameSheet, Long team);

    Wearable findByMatchSheetAndTeamAndPlayer(Long gameSheet, Long team, Long player);

}
