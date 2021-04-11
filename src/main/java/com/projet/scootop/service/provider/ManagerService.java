package com.projet.scootop.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.provider.Manager;
import com.projet.scootop.mappers.provider.ManagerMapper;
import com.projet.scootop.model.provider.ManagerDTO;
import com.projet.scootop.repository.provider.ManagerRepository;

import java.util.List;

@Service

public class ManagerService {
	
    @Autowired
    public ManagerRepository managerRepository;
    
    @Autowired
    private ManagerMapper mapper;
    
    public ManagerDTO add(ManagerDTO managerDTO){
        Manager manager = mapper.mapTo(managerDTO);
        managerRepository.save(manager);
        return mapper.mapTo(manager);
    }
    
    public ManagerDTO get(Long id){
        Manager manager = managerRepository.findById(id).orElse(null);
        if(manager==null){
            return null;
        }
        return mapper.mapTo(manager);
    }
    
    public List<ManagerDTO> getAll(){

        List<Manager> managers = managerRepository.findAll();
        return mapper.mapTo(managers);
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
