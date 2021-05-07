package com.projet.scootop.repository.services.tools.video;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.services.tools.video.VideoView;

@Repository
public interface VideoViewRepository extends JpaRepository<VideoView, Long> {

}
