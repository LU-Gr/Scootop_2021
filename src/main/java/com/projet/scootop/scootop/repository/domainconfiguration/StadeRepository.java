package com.projet.scootop.scootop.repository.domainconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Stadium;
import com.projet.scootop.scootop.model.domainconfiguration.StadeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface StadeRepository extends JpaRepository<Stadium,Integer> {
    @Modifying
    @Query("UPDATE Stade  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateStade(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
