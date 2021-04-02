package com.projet.scootop.scootop.model.provider;

import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.user.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class AnalysteDTO {
    public Integer id;
    public User user;
    public Integer tarif;
    public Integer experience;
    public MatchSheet matchSheet;

    public static AnalysteDTO create(User user, Integer tarif, Integer experience, MatchSheet matchSheet) {
        AnalysteDTO analysteDTO= new AnalysteDTO();
        analysteDTO.user = user;
        analysteDTO.tarif = tarif;
        analysteDTO.experience = experience;
        analysteDTO.matchSheet = matchSheet;
        return analysteDTO;
    }
    public static AnalysteDTO get(Integer id,User user, Integer tarif, Integer experience, MatchSheet matchSheet) {
        AnalysteDTO analysteDTO= new AnalysteDTO();
        analysteDTO.id=id;
        analysteDTO.user = user;
        analysteDTO.tarif = tarif;
        analysteDTO.experience = experience;
        analysteDTO.matchSheet = matchSheet;
        return analysteDTO;
    }


    @Override
    public String toString() {
        return "AnalysteDTO{" +
                "id=" + id +
                ", user=" + user +
                ", tarif=" + tarif +
                ", experience=" + experience +
                ", matchSheet=" + matchSheet +
                '}';
    }
}
