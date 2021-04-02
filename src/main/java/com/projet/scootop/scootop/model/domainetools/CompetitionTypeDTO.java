package com.projet.scootop.scootop.model.domainetools;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.servicetools.videosservices.Video;

public class CompetitionTypeDTO {
    public int id;
    public Video video;
    public String name;
    public int playerMax;
    public int playerMin;

    public int titulaire;
    public int remplacant;

    public int substition;
    public Category category;
    public int time;

    public static CompetitionTypeDTO create(String name, Video video, int playerMax, int playerMin, int titulaire, int remplacant, int substition, int time, Category category) {
        CompetitionTypeDTO competionTypeDTO = new CompetitionTypeDTO();
        competionTypeDTO.video = video;
        competionTypeDTO.name = name;
        competionTypeDTO.playerMax = playerMax;
        competionTypeDTO.playerMin = playerMin;
        competionTypeDTO.titulaire = titulaire;
        competionTypeDTO.remplacant = remplacant;
        competionTypeDTO.substition = substition;
        competionTypeDTO.category = category;
        competionTypeDTO.time = time;
        return competionTypeDTO;
    }


    @Override
    public String toString() {
        return "CompetitionTypeDTO{" +
                "id=" + id +
                ", video=" + video +
                ", name='" + name + '\'' +
                ", playerMax=" + playerMax +
                ", playerMin=" + playerMin +
                ", titulaire=" + titulaire +
                ", remplacant=" + remplacant +
                ", substition=" + substition +
                ", category=" + category +
                ", time=" + time +
                '}';
    }
}
