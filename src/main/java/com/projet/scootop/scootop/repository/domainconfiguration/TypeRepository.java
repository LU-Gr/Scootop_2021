package com.projet.scootop.scootop.repository.domainconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Type;
import com.projet.scootop.scootop.model.domainconfiguration.TypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface TypeRepository extends JpaRepository<Type,Integer> {
    @Modifying
    @Query("UPDATE Type  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateType(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);


}
