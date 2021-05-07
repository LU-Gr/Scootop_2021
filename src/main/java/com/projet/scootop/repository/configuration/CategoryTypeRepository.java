package com.projet.scootop.repository.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.configuration.CategoryType;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Long> {

}
