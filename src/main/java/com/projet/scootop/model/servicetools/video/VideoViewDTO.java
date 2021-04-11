package com.projet.scootop.model.servicetools.video;

import java.time.LocalDate;

import com.projet.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;

public class VideoViewDTO {

    @Getter @Setter
    private Integer id;
    
    @Getter @Setter
    private LocalDate date;

    @Getter @Setter
    private VideoDTO video;
    
    @Getter @Setter
    private User user;
}