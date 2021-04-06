package com.projet.scootop.scootop.service.provider;

import com.projet.scootop.scootop.domain.provider.MarketingAdvisor;
import com.projet.scootop.scootop.model.provider.MarketingAdvisorDTO;
import com.projet.scootop.scootop.repository.provider.MarketingAdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketingAdvisorService {
	
    @Autowired
    public MarketingAdvisorRepository marketingAdvisorRepository;
    
    
    public MarketingAdvisorDTO add(MarketingAdvisorDTO marketingAdvisorDTO) throws Exception {
        MarketingAdvisor scoot=new MarketingAdvisor(marketingAdvisorDTO.user,marketingAdvisorDTO.agence);
        marketingAdvisorRepository.save(scoot);
        return marketingAdvisorDTO;
    }
    
    public MarketingAdvisorDTO get(Long id){

        MarketingAdvisor marketingAdvisor = marketingAdvisorRepository.findById(id).orElse(null);
        if(marketingAdvisor==null){
            return null;
        }
        return MarketingAdvisorDTO.create(marketingAdvisor.user,marketingAdvisor.agence);
    }
    
    public List<MarketingAdvisorDTO> getAll(){

        List<MarketingAdvisor> marketingAdvisors = marketingAdvisorRepository.findAll();
        List<MarketingAdvisorDTO> marketingAdvisorDTOS = new ArrayList<>();
        for (MarketingAdvisor marketingAdvisor: marketingAdvisors) {
            MarketingAdvisorDTO marketingAdvisorDTO= MarketingAdvisorDTO.get(marketingAdvisor.id,marketingAdvisor.user,marketingAdvisor.agence);
            marketingAdvisorDTOS.add(marketingAdvisorDTO);
        }

        return marketingAdvisorDTOS;
    }
    public String delete(Long id){
        MarketingAdvisor scoot = marketingAdvisorRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        marketingAdvisorRepository.deleteById(id);

        return "Deleted";
    }

}
