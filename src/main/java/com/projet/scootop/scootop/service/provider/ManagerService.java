package com.projet.scootop.scootop.service.provider;

import com.projet.scootop.scootop.domain.provider.Manager;
import com.projet.scootop.scootop.model.provider.ManagerDTO;
import com.projet.scootop.scootop.repository.provider.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ManagerService {
	
    @Autowired
    public ManagerRepository managerRepository;
    
    public ManagerDTO add(ManagerDTO managerDTO){
        Manager scoot=new Manager(managerDTO.name,managerDTO.agence);
        managerRepository.save(scoot);
        return managerDTO;
    }
    
    public ManagerDTO get(Long id){

        Manager manager = managerRepository.findById(id).orElse(null);
        if(manager==null){
            return null;
        }
        return ManagerDTO.create(manager.name,manager.agence);
    }
    
    public List<ManagerDTO> getAll(){

        List<Manager> managers = managerRepository.findAll();
        List<ManagerDTO> managerDTOS = new ArrayList<>();
        for (Manager manager: managers) {
            ManagerDTO managerDTO= ManagerDTO.get(manager.id,manager.name,manager.agence);
            managerDTOS.add(managerDTO);
        }
        return managerDTOS;
    }
    
    public String delete(Long id){
        Manager scoot = managerRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        managerRepository.deleteById(id);

        return "Deleted";
    }

}
