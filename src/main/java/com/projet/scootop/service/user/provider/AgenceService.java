package com.projet.scootop.service.user.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.provider.Agence;
import com.projet.scootop.mappers.user.provider.AgenceMapper;
import com.projet.scootop.model.user.provider.AgenceDTO;
import com.projet.scootop.repository.user.provider.AgenceRepository;

import java.util.List;

@Service
public class AgenceService {
	
    @Autowired
    public AgenceRepository agenceRepository;
    
    @Autowired
    private AgenceMapper mapper;
    
    public AgenceDTO add(AgenceDTO agenceDTO){
        Agence agence = mapper.mapTo(agenceDTO);
        agenceRepository.save(agence);
        return mapper.mapToDTO(agence);
    }
    
    public AgenceDTO get(Long id){
        Agence agence = agenceRepository.findById(id).orElse(null);
        if(agence==null){
            return null;
        }
        return mapper.mapToDTO(agence);
    }
    
    public List<AgenceDTO> getAll(){
        List<Agence> agences = agenceRepository.findAll();
        return mapper.mapToDTO(agences);
    }
    
    public String delete(Long id){
        Agence scoot = agenceRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        agenceRepository.deleteById(id);

        return "Deleted";
    }

	public AgenceDTO update(AgenceDTO agenceDTO) {
		Agence agence = mapper.mapTo(agenceDTO);
        agenceRepository.save(agence);
        return mapper.mapToDTO(agence);
	}

}
