package com.projet.scootop.repository.services.tools.video;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.tools.video.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

}
