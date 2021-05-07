package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.Stade;
import com.projet.scootop.mappers.configuration.StadeMapper;
import com.projet.scootop.model.configuration.StadeDTO;
import com.projet.scootop.repository.configuration.StadeRepository;
import com.projet.scootop.repository.user.ContactRepository;

import java.util.List;

@Service
public class StadeService {
	
	@Autowired private ContactRepository contactRepository;
    @Autowired private StadeRepository stadeRepository;
    @Autowired private StadeMapper mapper;
    
    public StadeDTO add(StadeDTO stadeDTO){
        Stade newStadium = mapper.mapTo(stadeDTO);
        contactRepository.save(newStadium.getContact());
        stadeRepository.save(newStadium);
        return mapper.mapTo(newStadium);
    }

    public StadeDTO get(Long id){
        Stade stade = stadeRepository.findById(id).orElse(null);
        if(stade==null){
            return null;
        }
        return mapper.mapTo(stade);
    }
    
    public StadeDTO update(StadeDTO stadeDTO){
        Stade stade = mapper.mapTo(stadeDTO);
        contactRepository.save(stade.getContact());
        stadeRepository.save(stade);
        return mapper.mapTo(stade);
    }

    public List<StadeDTO> getAll(){
        List<Stade> stades = stadeRepository.findAll();
        return mapper.mapTo(stades);
    }
    
    public String delete(Long id){
        Stade stade = stadeRepository.findById(id).orElse(null);
        if(stade==null){
            return null;
        }
        stadeRepository.deleteById(id);
        return "Deleted";
    }

}
