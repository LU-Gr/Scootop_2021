package com.projet.scootop.scootop.repository.domainetools;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domaintools.CategoryType;

@Repository
public interface CategoryTypeRepository extends JpaRepository<CategoryType, Integer> {
    @Modifying
    @Query("UPDATE CategorieType  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateType(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
