package com.projet.scootop.domain.services.tools.video;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projet.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "video_view")
public class VideoView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private LocalDate date;

    @Getter @Setter
    @OneToOne
    @JsonIgnoreProperties("views")
    private Video video;
    
    @Getter @Setter
    @OneToOne
    private User user;
    
    public VideoView(Video video, User user) {
        this.video = video;
        this.user = user;
        this.date = LocalDate.now();
    }

    public VideoView() {

    }
}