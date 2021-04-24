package com.projet.scootop.repository.servicetools.video;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.servicetools.video.VideoView;

@Repository
public interface VideoViewRepository extends JpaRepository<VideoView, Long> {

}
