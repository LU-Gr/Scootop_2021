package com.projet.scootop.repository.servicetools.video;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.servicetools.video.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}
