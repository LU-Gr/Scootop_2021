package com.projet.scootop.scootop.repository.services;

import com.projet.scootop.scootop.domain.services.Wearable;
import com.projet.scootop.scootop.model.services.WearableDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WearableRepository extends JpaRepository<Wearable,Integer> {

    @Modifying
    @Query("UPDATE Wearable  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateWearable(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);


    List<Wearable> findAllById(int numbers);
    List<Wearable> findAllByTeam(int team);
    List<Wearable> findAllByMatchSheetAndTeam(int gameSheet, int team);

    Wearable findByMatchSheetAndTeamAndPlayer(int gameSheet, int team, int player);

}
