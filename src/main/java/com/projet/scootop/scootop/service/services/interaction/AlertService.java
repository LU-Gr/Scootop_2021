package com.projet.scootop.scootop.service.services.interaction;

import com.projet.scootop.scootop.domain.services.interaction.Alert;
import com.projet.scootop.scootop.model.services.interaction.AlertDTO;
import com.projet.scootop.scootop.repository.services.interaction.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {
	
    @Autowired
    public AlertRepository alertRepository;
    
    public AlertDTO add(AlertDTO alertDTO){
        Alert alert= new Alert(alertDTO.dateCreated,alertDTO.user,alertDTO.player,alertDTO.saison);
        alertRepository.save(alert);
        return alertDTO;
    }
    
    public AlertDTO get(Long id){

        Alert alert = alertRepository.findById(id).orElse(null);
        if(alert==null){
            return null;
        }
        AlertDTO alertDTO = AlertDTO.get(alert.id,alert.dateCreated,alert.user,alert.player,alert.saison);
        return alertDTO;
    }
    
    public List<AlertDTO> getAll(){

        List<Alert> alerts = alertRepository.findAll();
        ArrayList<AlertDTO> alertDTOArrayList = new ArrayList<>();
        for (Alert alert: alerts) {
            AlertDTO alertDTO = AlertDTO.create(alert.dateCreated,alert.user,alert.player,alert.saison);
            alertDTOArrayList.add(alertDTO);

        }
        return alertDTOArrayList;
    }
    public String delete(Long id){
        Alert alert = alertRepository.findById(id).orElse(null);
        if(alert==null){
            return null;
        }

        alertRepository.deleteById(id);

        return "Deleted";
    }

}
