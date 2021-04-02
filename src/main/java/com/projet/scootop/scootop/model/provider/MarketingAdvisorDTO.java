package com.projet.scootop.scootop.model.provider;

import com.projet.scootop.scootop.domain.provider.Agence;
import com.projet.scootop.scootop.user.User;

public class MarketingAdvisorDTO {

    int id;
    public User user;
    public Agence agence;

    public static MarketingAdvisorDTO create(User user, Agence agence) {
        MarketingAdvisorDTO marketingAdvisorDTO=new MarketingAdvisorDTO();
        marketingAdvisorDTO.user = user;
        marketingAdvisorDTO.agence = agence;
        return marketingAdvisorDTO;
    }
    public static MarketingAdvisorDTO get(Integer id,User user, Agence agence) {
        MarketingAdvisorDTO marketingAdvisorDTO=new MarketingAdvisorDTO();
        marketingAdvisorDTO.user = user;
        marketingAdvisorDTO.id = id;
        marketingAdvisorDTO.agence = agence;
        return marketingAdvisorDTO;
    }

}
