package com.projet.scootop.model.domaintools;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import com.projet.scootop.domain.inprogress.MatchSheet;

public class SaisonDTO {

	@Getter @Setter
    private Integer id;
	
	@Getter @Setter
    private LocalDate dateDebut;
	
	@Getter @Setter
    private LocalDate dateFin;
	
	@Getter @Setter
    private List<MatchSheet> matchSheets;

    public static SaisonDTO create(Integer id, LocalDate dateDebut, LocalDate dateFin, List<MatchSheet> matchSheets) {

        SaisonDTO saisonDTO =new SaisonDTO();
        saisonDTO.id = id;
        saisonDTO.dateDebut = dateDebut;
        saisonDTO.dateFin = dateFin;
        saisonDTO.matchSheets = matchSheets;
        return saisonDTO;
    }
    public static SaisonDTO get(Integer id, LocalDate dateDebut, LocalDate dateFin, List<MatchSheet> matchSheets) {

        SaisonDTO saisonDTO =new SaisonDTO();
        saisonDTO.id = id;
        saisonDTO.dateDebut = dateDebut;
        saisonDTO.dateFin = dateFin;
        saisonDTO.matchSheets = matchSheets;
        return saisonDTO;
    }
    
    public String getName() {
        return this.dateDebut.toString() + " - " + this.dateFin.toString();
    }

    @Override
    public String toString() {
        return "SaisonDTO{" +
                "id=" + id +
                '}';
    }
}
