package com.projet.scootop.scootop.repository.servicetools.videosservices;

import com.projet.scootop.scootop.servicetools.videosservices.VideoView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VideoViewRepository extends JpaRepository<VideoView, Integer> {
    @Modifying
    @Query("UPDATE VideoView  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateVideoView(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
