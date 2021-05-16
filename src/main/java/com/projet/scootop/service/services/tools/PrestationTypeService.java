package com.projet.scootop.service.services.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.tools.PrestationType;
import com.projet.scootop.mappers.services.tools.PrestationTypeMapper;
import com.projet.scootop.model.services.tools.PrestationTypeDTO;
import com.projet.scootop.repository.services.tools.PrestationTypeRepository;

@Service
public class PrestationTypeService {

	@Autowired PrestationTypeRepository repository;
	@Autowired PrestationTypeMapper mapper;
	
	public PrestationTypeDTO add(PrestationTypeDTO prestationTypeDTO){
		PrestationType prestationType = mapper.mapTo(prestationTypeDTO);
		repository.save(prestationType);
        return mapper.mapToDTO(prestationType);

    }
    public PrestationTypeDTO update(PrestationTypeDTO prestationTypeDTO){
    	PrestationType prestationType = mapper.mapTo(prestationTypeDTO);
    	repository.save(prestationType);
        return mapper.mapToDTO(prestationType);

    }
    public PrestationTypeDTO get(Long id){
    	PrestationType prestationType = repository.findById(id).orElse(null);
        return mapper.mapToDTO(prestationType);

    }
    public List<PrestationTypeDTO> getAll(){
    	List<PrestationType> prestationTypes = repository.findAll();
        return mapper.mapToDTO(prestationTypes);
    }
    
    public String delete(Long id){
    	PrestationType prestationType = repository.findById(id).orElse(null);
        if(prestationType==null){
            return null;
        }
        repository.deleteById(id);

        return "Deleted";
    }
}
