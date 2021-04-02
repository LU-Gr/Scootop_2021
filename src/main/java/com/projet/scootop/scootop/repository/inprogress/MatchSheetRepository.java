package com.projet.scootop.scootop.repository.inprogress;

import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.inprogress.MatchSheetDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchSheetRepository extends JpaRepository<MatchSheet, Integer> {
    @Modifying
    @Query("UPDATE MatchSheet  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateMatchSheet(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
