package com.projet.scootop.scootop.repository.domainetools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domaintools.CategoryType;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {

}
