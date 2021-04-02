package com.projet.scootop.scootop.repository.servicetools;

import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.servicetools.AgenceTypeDTO;
import com.projet.scootop.scootop.servicetools.AgenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceTypeRepository extends JpaRepository<AgenceType, Integer> {
    @Modifying
    @Query("UPDATE AgenceType  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateAgenceType(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}

