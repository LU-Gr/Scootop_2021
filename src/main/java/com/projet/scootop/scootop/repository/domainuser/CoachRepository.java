package com.projet.scootop.scootop.repository.domainuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domainuser.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach,Integer> {
    @Modifying
    @Query("UPDATE Coach  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateCoach(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
