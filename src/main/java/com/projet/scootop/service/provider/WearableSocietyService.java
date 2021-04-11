package com.projet.scootop.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.provider.WearableSociety;
import com.projet.scootop.mappers.provider.WearableSocietyMapper;
import com.projet.scootop.model.provider.WearableSocietyDTO;
import com.projet.scootop.repository.provider.WearableSocietyRepository;
import com.projet.scootop.repository.user.ContactRepository;

import java.util.List;

@Service
public class WearableSocietyService {

    @Autowired
    private WearableSocietyRepository wearableSocietyRepository;
    
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private WearableSocietyMapper mapper;

    public WearableSocietyDTO add(WearableSocietyDTO wearableSocietyDTO){
    	WearableSociety wearableSociety = mapper.mapTo(wearableSocietyDTO);
        contactRepository.save(wearableSociety.getContact());
        wearableSocietyRepository.save(wearableSociety);
        return mapper.mapTo(wearableSociety);
    }

    public WearableSocietyDTO get(Long id){
        WearableSociety wearableSociety = wearableSocietyRepository.findById(id).orElse(null);
        if(wearableSociety==null){
            return null;
        }
        return mapper.mapTo(wearableSociety);
    }

    public WearableSocietyDTO update(WearableSocietyDTO wearableSocietyDTO, Long id){
    	WearableSociety wearableSociety = mapper.mapTo(wearableSocietyDTO);
        contactRepository.save(wearableSociety.getContact());
        wearableSocietyRepository.save(wearableSociety);
        return mapper.mapTo(wearableSociety);
    }

    public List<WearableSocietyDTO> getAll(){
        List<WearableSociety> wearableSocieties = wearableSocietyRepository.findAll();
        return mapper.mapTo(wearableSocieties);
    }

    public String delete(Long id){

        WearableSociety wearableSociety = wearableSocietyRepository.findById(id).orElse(null);
        if(wearableSociety==null){
            return null;
        }

        wearableSocietyRepository.deleteById(id);

        return "Deleted";
    }
}
