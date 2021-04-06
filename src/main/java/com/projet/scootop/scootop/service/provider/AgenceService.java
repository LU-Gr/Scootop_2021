package com.projet.scootop.scootop.service.provider;

import com.projet.scootop.scootop.domain.provider.Agence;
import com.projet.scootop.scootop.model.provider.AgenceDTO;
import com.projet.scootop.scootop.repository.provider.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgenceService {
	
    @Autowired
    public AgenceRepository agenceRepository;
    
    public AgenceDTO add(AgenceDTO agenceDTO){
        Agence scoot=new Agence(agenceDTO.region,agenceDTO.marketingAdvisors,agenceDTO.manager);
        agenceRepository.save(scoot);
        return agenceDTO;
    }
    
    public AgenceDTO get(Long id){
        Agence agence = agenceRepository.findById(id).orElse(null);
        if(agence==null){
            return null;
        }
        AgenceDTO agenceDTO = AgenceDTO.create(agence.region,agence.marketingAdvisors,agence.manager);
        return agenceDTO;
    }
    
    public List<AgenceDTO> getAll(){
        List<Agence> chairmen = agenceRepository.findAll();
        List<AgenceDTO> agenceDTOS = new ArrayList<>();
        for (Agence agence: chairmen) {
            AgenceDTO agenceDTO= AgenceDTO.get(agence.id,agence.region,agence.marketingAdvisors,agence.manager);
            agenceDTOS.add(agenceDTO);
        }
        return agenceDTOS;
    }
    
    public String delete(Long id){
        Agence scoot = agenceRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        agenceRepository.deleteById(id);

        return "Deleted";
    }

}
