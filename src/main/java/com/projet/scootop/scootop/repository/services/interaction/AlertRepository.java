package com.projet.scootop.scootop.repository.services.interaction;

import com.projet.scootop.scootop.domain.services.interaction.Alert;
import com.projet.scootop.scootop.model.services.interaction.AlertDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert,Integer> {
    @Modifying
    @Query("UPDATE Alert  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateAlert(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
