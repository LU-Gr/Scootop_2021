package com.projet.scootop.scootop.repository.provider;

import com.projet.scootop.scootop.domain.provider.Manager;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.provider.ManagerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    @Modifying
    @Query("UPDATE Manager  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateManager(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
