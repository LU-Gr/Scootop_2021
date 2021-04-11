package com.projet.scootop.service.services.interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.interaction.Alert;
import com.projet.scootop.mappers.services.interaction.AlertMapper;
import com.projet.scootop.model.services.interaction.AlertDTO;
import com.projet.scootop.repository.services.interaction.AlertRepository;

import java.util.List;

@Service
public class AlertService {
	
    @Autowired private AlertRepository alertRepository;
    @Autowired private AlertMapper mapper;
    
    
    
    public AlertDTO add(AlertDTO alertDTO){
        Alert alert = mapper.mapTo(alertDTO);
        alertRepository.save(alert);
        return alertDTO;
    }
    
    public AlertDTO get(Long id){
        Alert alert = alertRepository.findById(id).orElse(null);
        if(alert==null){
            return null;
        }
        return mapper.mapTo(alert);
    }
    
    public List<AlertDTO> getAll(){
    	List<Alert> alerts = alertRepository.findAll();
    	return mapper.mapTo(alerts);
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
