package com.projet.scootop.service.statistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.Shoot;
import com.projet.scootop.mappers.statistical.ShootMapper;
import com.projet.scootop.model.statistical.ShootDTO;
import com.projet.scootop.repository.domainconfiguration.MatchSheetRepository;
import com.projet.scootop.repository.statistical.ShootRepository;

import java.util.List;

@Service
public class ShootService {
	
    @Autowired private ShootRepository shootRepository;
    @Autowired private MatchSheetRepository matchSheetRepository;
    @Autowired private ShootMapper mapper;
    
    public ShootDTO add(ShootDTO shootDTO){
        Shoot shoot = mapper.mapTo(shootDTO);
        matchSheetRepository.save(shoot.getMatchSheet());
        shootRepository.save(shoot);
        return mapper.mapTo(shoot);
    }
    
    public ShootDTO get(Long id){
    	Shoot shoot = shootRepository.findById(id).orElse(null);
        return mapper.mapTo(shoot);
    }
    
    public ShootDTO update(ShootDTO shootDTO){ 
    	Shoot shoot = mapper.mapTo(shootDTO);
        matchSheetRepository.save(shoot.getMatchSheet());
        shootRepository.save(shoot);
        return mapper.mapTo(shoot);
    }
    
    public List<ShootDTO> getAll(){
    	List<Shoot> shoots = shootRepository.findAll();
        return mapper.mapTo(shoots);
    }
    
    public String delete(Long id){
        shootRepository.deleteById(id);

        return "Deleted";
    }
}
