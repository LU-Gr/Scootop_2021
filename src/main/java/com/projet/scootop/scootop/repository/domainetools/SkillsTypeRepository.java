package com.projet.scootop.scootop.repository.domainetools;

import com.projet.scootop.scootop.domain.domaintools.SkillType;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.domainetools.SkillsTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsTypeRepository extends JpaRepository<SkillType, Integer> {
    @Modifying
    @Query("UPDATE SkillsType  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateSkillsType(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
