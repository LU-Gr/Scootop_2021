package com.projet.scootop.scootop.repository.statistical;

import com.projet.scootop.scootop.domain.stastistical.Action;
import com.projet.scootop.scootop.model.statistical.SkillDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Action,Integer> {
    @Modifying
    @Query("UPDATE Skill  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateSkill(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
