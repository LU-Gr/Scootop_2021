package com.projet.scootop.scootop.repository.domainconfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domainconfiguration.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {
    @Modifying
    @Query("UPDATE Club  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateClub(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
