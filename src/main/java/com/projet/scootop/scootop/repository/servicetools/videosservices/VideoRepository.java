package com.projet.scootop.scootop.repository.servicetools.videosservices;

import com.projet.scootop.scootop.servicetools.videosservices.Video;
import com.projet.scootop.scootop.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    @Modifying
    @Query("UPDATE Video  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateVideo(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
