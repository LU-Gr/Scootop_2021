package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Stade;
import com.projet.scootop.scootop.model.domainconfiguration.StadeDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.StadeRepository;
import com.projet.scootop.scootop.repository.user.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StadeService {
    @Autowired
    public StadeRepository stadeRepository;
    @Autowired
    public ContactRepository contactRepository;
    
    public Stade add(StadeDTO stadeDTO){

        contactRepository.save(stadeDTO.contact);
        Stade newStadium = new Stade(stadeDTO.name, stadeDTO.contact);
        return stadeRepository.save(newStadium);

    }

    public StadeDTO get(Long id){

        Stade stade = stadeRepository.findById(id).orElse(null);

        if(stade==null){
            return null;
        }
        return StadeDTO.get(stade.getId(),stade.getName(),stade.getContact());

    }
    public Stade update(StadeDTO stadeDTO,Long id){

        contactRepository.save(stadeDTO.contact);
        Stade stade= new Stade(stadeDTO.name,stadeDTO.contact);
        stade.setId(id);
        return stadeRepository.save(stade);
    }

    public List<StadeDTO> getAll(){
        List<Stade> stades = stadeRepository.findAll();

        return stades.stream().map(stade -> StadeDTO.get(stade.getId(),stade.getName(),stade.getContact())).collect(Collectors.toList());
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
