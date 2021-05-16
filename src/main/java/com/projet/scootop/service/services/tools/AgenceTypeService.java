package com.projet.scootop.service.services.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.tools.AgenceType;
import com.projet.scootop.mappers.services.tools.AgenceTypeMapper;
import com.projet.scootop.model.services.tools.AgenceTypeDTO;
import com.projet.scootop.repository.services.tools.AgenceTypeRepository;

@Service
public class AgenceTypeService {

	@Autowired AgenceTypeRepository repository;
	@Autowired AgenceTypeMapper mapper;
	
	
	public AgenceTypeDTO add(AgenceTypeDTO agenceDTO){
		AgenceType agenceType = mapper.mapTo(agenceDTO);
		repository.save(agenceType);
        return mapper.mapToDTO(agenceType);

    }
    public AgenceTypeDTO update(AgenceTypeDTO agenceDTO){
    	AgenceType agenceType = mapper.mapTo(agenceDTO);
    	repository.save(agenceType);
        return mapper.mapToDTO(agenceType);

    }
    public AgenceTypeDTO get(Long id){
    	AgenceType agenceType = repository.findById(id).orElse(null);
        return mapper.mapToDTO(agenceType);

    }
    public List<AgenceTypeDTO> getAll(){
    	List<AgenceType> agenceTypes = repository.findAll();
        return mapper.mapToDTO(agenceTypes);
    }
    
    public String delete(Long id){
    	AgenceType agenceType = repository.findById(id).orElse(null);
        if(agenceType==null){
            return null;
        }
        repository.deleteById(id);

        return "Deleted";
    }
}
