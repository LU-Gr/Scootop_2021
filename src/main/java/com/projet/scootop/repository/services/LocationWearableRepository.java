package com.projet.scootop.repository.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.LocationWearable;
import java.util.List;

@Repository
public interface LocationWearableRepository extends JpaRepository<LocationWearable,Long> {

    List<LocationWearable> findAllByTeam(Long team);
    List<LocationWearable> findAllByMatchAndTeam(Long gameSheet, Long team);

    LocationWearable findByMatchAndTeamAndPlayer(Long gameSheet, Long team, Long player);

}
