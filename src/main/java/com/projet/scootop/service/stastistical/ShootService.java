package com.projet.scootop.service.stastistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.Shoot;
import com.projet.scootop.model.statistical.ShootDTO;
import com.projet.scootop.repository.inprogress.MatchSheetRepository;
import com.projet.scootop.repository.statistical.ShootRepository;

import java.util.List;

@Service
public class ShootService {
	
    @Autowired
    public ShootRepository shootRepository;
    
    @Autowired
    public MatchSheetRepository matchSheetRepository;
    
    public Shoot add(ShootDTO shootDTO){
        matchSheetRepository.save(shootDTO.matchSheet);
        Shoot shoot = new Shoot(shootDTO.matchSheet,shootDTO.typeTouch,shootDTO.player,shootDTO.inBox,shootDTO.isGoal,shootDTO.isLongShoot,shootDTO.assist);
        return shootRepository.save(shoot);
    }
    
    public Shoot get(Long id){
        return shootRepository.findById(id).orElse(null);
    }
    
    public Shoot update(ShootDTO shootDTO,Long id){
        matchSheetRepository.save(shootDTO.matchSheet);
        Shoot shoot = new Shoot(shootDTO.matchSheet,shootDTO.typeTouch,shootDTO.player,shootDTO.inBox,shootDTO.isGoal,shootDTO.isLongShoot,shootDTO.assist);
        shoot.id=id;
        return shootRepository.save(shoot);
    }
    
    public List<Shoot> getAll(){
        return shootRepository.findAll();
    }
    
    public String delete(Long id){
        shootRepository.deleteById(id);

        return "Deleted";
    }
}
