package com.projet.scootop.scootop.repository.domainuser;

import com.projet.scootop.scootop.domain.domainuser.Chairman;
import com.projet.scootop.scootop.model.domainuser.ChairmanDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairmanRepository extends JpaRepository<Chairman,Integer> {
    @Modifying
    @Query("UPDATE Chairman  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateChairman(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
