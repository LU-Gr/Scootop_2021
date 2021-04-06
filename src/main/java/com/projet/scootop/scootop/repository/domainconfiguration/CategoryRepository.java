package com.projet.scootop.scootop.repository.domainconfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
