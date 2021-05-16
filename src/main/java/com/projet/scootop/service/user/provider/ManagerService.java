package com.projet.scootop.service.user.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.provider.Manager;
import com.projet.scootop.mappers.user.provider.ManagerMapper;
import com.projet.scootop.model.user.provider.ManagerDTO;
import com.projet.scootop.repository.user.provider.ManagerRepository;

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
        return mapper.mapToDTO(manager);
    }
    
    public ManagerDTO get(Long id){
        Manager manager = managerRepository.findById(id).orElse(null);
        if(manager==null){
            return null;
        }
        return mapper.mapToDTO(manager);
    }
    
    public List<ManagerDTO> getAll(){

        List<Manager> managers = managerRepository.findAll();
        return mapper.mapToDTO(managers);
    }
    
    public String delete(Long id){
        Manager scoot = managerRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        managerRepository.deleteById(id);

        return "Deleted";
    }

	public ManagerDTO update(ManagerDTO managerDTO) {
		Manager manager = mapper.mapTo(managerDTO);
        managerRepository.save(manager);
        return mapper.mapToDTO(manager);
	}

}
