package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.WearableCompany;
import com.projet.scootop.mappers.services.WearableCompanyMapper;
import com.projet.scootop.model.services.WearableCompanyDTO;
import com.projet.scootop.repository.services.WearableCompanyRepository;
import com.projet.scootop.repository.user.ContactRepository;

import java.util.List;

@Service
public class WearableCompanyService {

    @Autowired
    private WearableCompanyRepository wearableSocietyRepository;
    
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private WearableCompanyMapper mapper;

    public WearableCompanyDTO add(WearableCompanyDTO wearableSocietyDTO){
    	WearableCompany wearableSociety = mapper.mapTo(wearableSocietyDTO);
        contactRepository.save(wearableSociety.getContact());
        wearableSocietyRepository.save(wearableSociety);
        return mapper.mapToDTO(wearableSociety);
    }

    public WearableCompanyDTO get(Long id){
        WearableCompany wearableSociety = wearableSocietyRepository.findById(id).orElse(null);
        if(wearableSociety==null){
            return null;
        }
        return mapper.mapToDTO(wearableSociety);
    }

    public WearableCompanyDTO update(WearableCompanyDTO wearableSocietyDTO){
    	WearableCompany wearableSociety = mapper.mapTo(wearableSocietyDTO);
        contactRepository.save(wearableSociety.getContact());
        wearableSocietyRepository.save(wearableSociety);
        return mapper.mapToDTO(wearableSociety);
    }

    public List<WearableCompanyDTO> getAll(){
        List<WearableCompany> wearableSocieties = wearableSocietyRepository.findAll();
        return mapper.mapToDTO(wearableSocieties);
    }

    public String delete(Long id){

        WearableCompany wearableSociety = wearableSocietyRepository.findById(id).orElse(null);
        if(wearableSociety==null){
            return null;
        }

        wearableSocietyRepository.deleteById(id);

        return "Deleted";
    }
}
