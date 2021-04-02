package com.projet.scootop.scootop.repository.domainconfiguration;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domainconfiguration.Division;

import java.util.List;

@Repository
public interface DivisionsRepository extends JpaRepository<Division, Integer> {
    @Modifying
    @Query("UPDATE Divisions  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateDivision(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);
    public List<Division> findAllByLeagueId(int leagueId);
}
