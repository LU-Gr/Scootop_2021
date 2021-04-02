package com.projet.scootop.scootop.repository.domainetools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domaintools.CompetitionType;

@Repository
public interface CompetitionTypeRepository extends JpaRepository<CompetitionType, Integer> {
    @Modifying
    @Query("UPDATE CompetitionType  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateCompetionType(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
