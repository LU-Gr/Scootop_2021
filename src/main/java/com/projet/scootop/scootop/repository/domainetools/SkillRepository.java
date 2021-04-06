package com.projet.scootop.scootop.repository.domainetools;

import com.projet.scootop.scootop.domain.domaintools.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}

