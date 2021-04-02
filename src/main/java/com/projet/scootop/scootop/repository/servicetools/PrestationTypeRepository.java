package com.projet.scootop.scootop.repository.servicetools;

import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.servicetools.PrestationTypeDTO;
import com.projet.scootop.scootop.servicetools.PrestationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestationTypeRepository extends JpaRepository<PrestationType, Integer> {
    @Modifying
    @Query("UPDATE PrestationType  SET name = :name, firstName = :firstName WHERE id = :id")
    int updatePrestationType(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);


}

