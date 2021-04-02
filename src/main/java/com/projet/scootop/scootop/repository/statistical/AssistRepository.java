package com.projet.scootop.scootop.repository.statistical;

import com.projet.scootop.scootop.domain.stastistical.Pass;
import com.projet.scootop.scootop.model.statistical.AssistDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistRepository extends JpaRepository<Pass,Integer> {
    @Modifying
    @Query("UPDATE Assist  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateAssist(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
