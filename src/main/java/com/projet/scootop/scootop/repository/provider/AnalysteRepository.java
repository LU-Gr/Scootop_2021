package com.projet.scootop.scootop.repository.provider;

import com.projet.scootop.scootop.domain.provider.Analyste;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.provider.AnalysteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysteRepository extends JpaRepository<Analyste, Integer> {
    @Modifying
    @Query("UPDATE Analyste  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateAnalyste(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
