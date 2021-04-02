package com.projet.scootop.scootop.repository.provider;

import com.projet.scootop.scootop.domain.provider.WearableSociety;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.provider.WearableSocietyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WearableSocietyRepository extends JpaRepository<WearableSociety, Integer> {
    @Modifying
    @Query("UPDATE WearableSociety  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateWearableSociety(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
