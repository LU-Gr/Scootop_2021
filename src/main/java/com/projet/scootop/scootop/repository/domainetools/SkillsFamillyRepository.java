package com.projet.scootop.scootop.repository.domainetools;

import com.projet.scootop.scootop.domain.domaintools.Skill;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.domainetools.SkillsFamillyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsFamillyRepository extends JpaRepository<Skill, Integer> {
    @Modifying
    @Query("UPDATE SkillsFamilly  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateSkillsFamilly(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}

