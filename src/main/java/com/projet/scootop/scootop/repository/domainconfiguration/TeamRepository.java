package com.projet.scootop.scootop.repository.domainconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.model.domainconfiguration.TeamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface TeamRepository extends JpaRepository<Team,Integer> {
    @Modifying
    @Query("UPDATE Team  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateTeam(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);


}