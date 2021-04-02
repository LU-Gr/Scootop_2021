package com.projet.scootop.scootop.repository.services;

import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.services.UserResume;
import com.projet.scootop.scootop.model.services.UserResumeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResumeRepository extends JpaRepository<UserResume,Integer> {
    @Modifying
    @Query("UPDATE UserResume  SET player = :player WHERE id = :id")
    int updateUserResume(@Param("player")Player player, @Param("id") Integer id);

}
