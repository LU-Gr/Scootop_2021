package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Poste;
import com.projet.scootop.scootop.domain.domainconfiguration.Stadium;
import com.projet.scootop.scootop.model.ContactDTO;
import com.projet.scootop.scootop.model.domainconfiguration.PosteDTO;
import com.projet.scootop.scootop.model.domainconfiguration.StadeDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.StadeRepository;
import com.projet.scootop.scootop.repository.user.ContactRepository;
import com.projet.scootop.scootop.user.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StadeService {
    @Autowired
    public StadeRepository stadeRepository;
    @Autowired
    public ContactRepository contactRepository;
    
    public Stadium add(StadeDTO stadeDTO){

        contactRepository.save(stadeDTO.contact);
        Stadium newStadium = new Stadium(stadeDTO.name, stadeDTO.contact);
        return stadeRepository.save(newStadium);

    }

    public StadeDTO get(Integer id){

        Stadium stade = stadeRepository.findById(id).orElse(null);

        if(stade==null){
            return null;
        }
        return StadeDTO.get(stade.id,stade.name,stade.contact);

    }
    public Stadium update(StadeDTO stadeDTO,Integer id){

        contactRepository.save(stadeDTO.contact);
        Stadium stade= new Stadium(stadeDTO.name,stadeDTO.contact);
        stade.id=id;
        return stadeRepository.save(stade);
    }

    public List<StadeDTO> getAll(){
        List<Stadium> stades = stadeRepository.findAll();

        return stades.stream().map(stade -> StadeDTO.get(stade.id,stade.name,stade.contact)).collect(Collectors.toList());
    }
    public String delete(Integer id){
        Stadium stade = stadeRepository.findById(id).orElse(null);
        if(stade==null){
            return null;
        }

        stadeRepository.deleteById(id);

        return "Deleted";
    }

}
