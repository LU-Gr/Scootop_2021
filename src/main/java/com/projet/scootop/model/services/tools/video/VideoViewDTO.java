package com.projet.scootop.model.services.tools.video;

import java.time.LocalDate;

import com.projet.scootop.model.user.UserDTO;

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
    private UserDTO user;
}