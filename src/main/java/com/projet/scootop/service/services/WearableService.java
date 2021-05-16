package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.Wearable;
import com.projet.scootop.mappers.services.WearableMapper;
import com.projet.scootop.model.services.WearableDTO;
import com.projet.scootop.repository.services.WearableRepository;
import java.util.*;

@Service
public class WearableService {
	
    @Autowired private WearableRepository wearableRepository;
    @Autowired private WearableMapper mapper;

    public WearableDTO add(WearableDTO wearableDTO){
    	Wearable wearable = mapper.mapTo(wearableDTO);
        wearableRepository.save(wearable);
        return mapper.mapToDTO(wearable);
    }

    public WearableDTO get(Long id){
        Wearable wearable = wearableRepository.findById(id).orElse(null);
        if(wearable==null){
            return null;
        }
        return mapper.mapToDTO(wearable);
    }

    public WearableDTO update(WearableDTO wearableDTO){
    	Wearable wearable = mapper.mapTo(wearableDTO);
        wearableRepository.save(wearable);
        return mapper.mapToDTO(wearable);
    }

    public List<WearableDTO> getAll(){
        List<Wearable> wearables = wearableRepository.findAll();
        return mapper.mapToDTO(wearables);
    }


    public String delete(Long id){
        wearableRepository.deleteById(id);

        return "Deleted";
    }
}
