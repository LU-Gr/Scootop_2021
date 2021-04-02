package com.projet.scootop.scootop.model.provider;

import java.util.List;

import com.projet.scootop.scootop.domain.provider.Manager;
import com.projet.scootop.scootop.domain.provider.MarketingAdvisor;

public class AgenceDTO {
    public Integer id;
    public String region;
    public List<MarketingAdvisor> marketingAdvisors;
    public List<Manager> manager;

    public static AgenceDTO create(String region, List<MarketingAdvisor> marketingAdvisors, List<Manager> manager) {
        AgenceDTO agenceDTO= new AgenceDTO();
        agenceDTO.region = region;
        agenceDTO.marketingAdvisors = marketingAdvisors;
        agenceDTO.manager = manager;
        return agenceDTO;
    }
    public static AgenceDTO get(Integer id, String region, List<MarketingAdvisor> marketingAdvisors, List<Manager> manager) {
        AgenceDTO agenceDTO= new AgenceDTO();
        agenceDTO.id = id;
        agenceDTO.region = region;
        agenceDTO.marketingAdvisors = marketingAdvisors;
        agenceDTO.manager = manager;
        return agenceDTO;
    }

    @Override
    public String toString() {
        return "AgenceDTO{" +
                "id=" + id +
                ", region='" + region + '\'' +
                ", marketingAdvisors=" + marketingAdvisors +
                ", manager=" + manager +
                '}';
    }
}
