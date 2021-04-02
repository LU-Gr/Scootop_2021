package com.projet.scootop.scootop.model.domainetools;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.projet.scootop.scootop.domain.inprogess.MatchSheet;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class SaisonDTO {

    public Integer id;
    public String name;
    public LocalDate dateDebut;
    public LocalDate dateFin;
    public List<MatchSheet> matchSheets;

    public static SaisonDTO create(Integer id, String name, LocalDate dateDebut, LocalDate dateFin, List<MatchSheet> matchSheets) {

        SaisonDTO saisonDTO =new SaisonDTO();
        saisonDTO.id = id;
        saisonDTO.name = name;
        saisonDTO.dateDebut = dateDebut;
        saisonDTO.dateFin = dateFin;
        saisonDTO.matchSheets = matchSheets;
        return saisonDTO;
    }
    public static SaisonDTO get(Integer id, String name, LocalDate dateDebut, LocalDate dateFin, List<MatchSheet> matchSheets) {

        SaisonDTO saisonDTO =new SaisonDTO();
        saisonDTO.id = id;
        saisonDTO.name = name;
        saisonDTO.dateDebut = dateDebut;
        saisonDTO.dateFin = dateFin;
        saisonDTO.matchSheets = matchSheets;
        return saisonDTO;
    }

    @Override
    public String toString() {
        return "SaisonDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
