package com.projet.scootop.scootop.repository.domainetools;

import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.domainetools.SaisonDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SaisonRepository extends JpaRepository<Saison, Integer> {
    @Modifying
    @Query("UPDATE Saison  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateSaison(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
