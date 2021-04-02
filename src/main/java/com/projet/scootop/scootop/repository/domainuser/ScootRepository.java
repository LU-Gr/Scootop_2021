package com.projet.scootop.scootop.repository.domainuser;

import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.domain.services.Wearable;
import com.projet.scootop.scootop.model.domainuser.ScootDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScootRepository extends JpaRepository<Scoot,Integer> {
    @Modifying
    @Query("UPDATE Scoot  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateScoot(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);


    List<Scoot> findAllById(int Sheet);

}
