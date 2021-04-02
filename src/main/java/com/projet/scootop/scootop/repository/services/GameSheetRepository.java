package com.projet.scootop.scootop.repository.services;

import com.projet.scootop.scootop.domain.services.GameSheet;
import com.projet.scootop.scootop.model.services.GameSheetDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSheetRepository extends JpaRepository<GameSheet,Integer> {
    @Modifying
    @Query("UPDATE GameSheet  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateGameSheet(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);


}
