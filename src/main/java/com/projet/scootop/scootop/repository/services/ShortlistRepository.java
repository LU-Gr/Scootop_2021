package com.projet.scootop.scootop.repository.services;

import com.projet.scootop.scootop.domain.services.Shortlist;
import com.projet.scootop.scootop.model.services.ShortlistDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortlistRepository extends JpaRepository<Shortlist,Integer> {
    @Modifying
    @Query("UPDATE Shortlist  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateShortlist(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
