package com.projet.scootop.scootop.service.provider;

import com.projet.scootop.scootop.domain.provider.WearableSociety;
import com.projet.scootop.scootop.model.provider.WearableSocietyDTO;
import com.projet.scootop.scootop.repository.provider.WearableSocietyRepository;
import com.projet.scootop.scootop.repository.user.ContactRepository;
import com.projet.scootop.scootop.domain.user.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WearableSocietyService {

    @Autowired
    public WearableSocietyRepository wearableSocietyRepository;
    @Autowired
    public ContactRepository contactRepository;

    public WearableSociety add(WearableSocietyDTO wearableSocietyDTO){
        Contact contact=contactRepository.save(wearableSocietyDTO.contact);
        WearableSociety wearableSociety=new WearableSociety(wearableSocietyDTO.name,wearableSocietyDTO.societe,wearableSocietyDTO.ceo,wearableSocietyDTO.specialite,wearableSocietyDTO.tarif,contact);
        return wearableSocietyRepository.save(wearableSociety);
    }

    public WearableSocietyDTO get(Long id){
        WearableSociety wearableSociety = wearableSocietyRepository.findById(id).orElse(null);
        if(wearableSociety==null){
            return null;
        }
        return WearableSocietyDTO.get(wearableSociety.id, wearableSociety.name, wearableSociety.societe, wearableSociety.ceo, wearableSociety.specialite, wearableSociety.tarif, wearableSociety.contact);
    }

    public WearableSociety update(WearableSocietyDTO wearableSocietyDTO, Long id){
        contactRepository.save(wearableSocietyDTO.contact);
        WearableSociety wearableSociety =new WearableSociety(wearableSocietyDTO.name, wearableSocietyDTO.societe, wearableSocietyDTO.ceo, wearableSocietyDTO.specialite, wearableSocietyDTO.tarif, wearableSocietyDTO.contact);
        wearableSociety.id=id;
        return wearableSocietyRepository.save(wearableSociety);
    }

    public List<WearableSocietyDTO> getAll(){

        List<WearableSociety> wearableSocieties = wearableSocietyRepository.findAll();
        return wearableSocieties.stream().map(wearableSociety -> WearableSocietyDTO.get(wearableSociety.id, wearableSociety.name, wearableSociety.societe, wearableSociety.ceo, wearableSociety.specialite, wearableSociety.tarif, wearableSociety.contact)).collect(Collectors.toList());
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
