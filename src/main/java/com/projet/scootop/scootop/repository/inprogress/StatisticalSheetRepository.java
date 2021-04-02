package com.projet.scootop.scootop.repository.inprogress;

import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.domain.services.Wearable;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.inprogress.StatisticalSheetDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticalSheetRepository extends JpaRepository<StatisticalSheet, Integer> {
    @Modifying
    @Query("UPDATE StatisticalSheet  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateStatisticalSheet(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

    StatisticalSheet findByMatchSheet(int gameSheet);

}
