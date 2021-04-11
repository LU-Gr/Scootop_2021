package com.projet.scootop.repository.domainetools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.domaintools.SkillType;

@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Long> {

}
