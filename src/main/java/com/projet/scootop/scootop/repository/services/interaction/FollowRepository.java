package com.projet.scootop.scootop.repository.services.interaction;


import com.projet.scootop.scootop.domain.services.interaction.Follow;
import com.projet.scootop.scootop.model.services.interaction.FollowDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Integer> {
    @Modifying
    @Query("UPDATE Follow  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateFollow(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
