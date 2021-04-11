package com.projet.scootop.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.provider.MarketingAdvisor;
import com.projet.scootop.mappers.provider.MarketingAdvisorMapper;
import com.projet.scootop.model.provider.MarketingAdvisorDTO;
import com.projet.scootop.repository.provider.MarketingAdvisorRepository;

import java.util.List;

@Service
public class MarketingAdvisorService {
	
    @Autowired
    private MarketingAdvisorRepository marketingAdvisorRepository;
    
    @Autowired
    private MarketingAdvisorMapper mapper;
    
    public MarketingAdvisorDTO add(MarketingAdvisorDTO marketingAdvisorDTO) throws Exception {
        MarketingAdvisor marketingAdvisor = mapper.mapTo(marketingAdvisorDTO);
        marketingAdvisorRepository.save(marketingAdvisor);
        return mapper.mapTo(marketingAdvisor);
    }
    
    public MarketingAdvisorDTO get(Long id){

        MarketingAdvisor marketingAdvisor = marketingAdvisorRepository.findById(id).orElse(null);
        if(marketingAdvisor==null){
            return null;
        }
        return mapper.mapTo(marketingAdvisor);
    }
    
    public List<MarketingAdvisorDTO> getAll(){

        List<MarketingAdvisor> marketingAdvisors = marketingAdvisorRepository.findAll();
        return mapper.mapTo(marketingAdvisors);
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
