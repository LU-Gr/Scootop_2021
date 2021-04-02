package com.projet.scootop.scootop.repository.provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.provider.Cameraman;

@Repository
public interface CameramanRepository extends JpaRepository<Cameraman, Integer> {
    @Modifying
    @Query("UPDATE Cameraman  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateCameraman(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
