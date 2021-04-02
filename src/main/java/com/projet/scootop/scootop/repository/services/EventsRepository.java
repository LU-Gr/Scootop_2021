package com.projet.scootop.scootop.repository.services;

import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.model.services.EventsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events,Integer> {
    @Modifying
    @Query("UPDATE Events  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateEvents(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);


}
