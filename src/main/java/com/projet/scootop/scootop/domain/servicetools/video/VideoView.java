package com.projet.scootop.scootop.domain.servicetools.video;

import java.time.LocalDate;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Vues")
public class VideoView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private LocalDate date;

    @Getter @Setter
    private Video video;
    
    @Getter @Setter
    private User user;
    
    

    public VideoView(Video video, User user) {
        this.video = video;
        this.user = user;
        this.date = LocalDate.now();
    }

    public VideoView() {

    }
}