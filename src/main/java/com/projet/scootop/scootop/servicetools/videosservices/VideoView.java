package com.projet.scootop.scootop.servicetools.videosservices;

import javax.persistence.*;


@Entity
@Table(name = "Vues")
public class VideoView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne
    Video video;

    public VideoView(Video video) {
        this.video = video;
    }

    public VideoView() {

    }
}
