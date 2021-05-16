package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.mappers.configuration.PosteMapper;
import com.projet.scootop.model.configuration.PosteDTO;
import com.projet.scootop.repository.configuration.PosteRepository;

import java.util.List;

@Service
public class PosteService {
    
	@Autowired private PosteRepository posteRepository;
	@Autowired private PosteMapper mapper;

    public PosteDTO addPoste(PosteDTO posteDTO) {

        Poste poste = mapper.mapTo(posteDTO);
        posteRepository.save(poste);
        return mapper.mapToDTO(poste);

    }
    
    public PosteDTO get(Long id) {

        Poste poste = posteRepository.findById(id).orElse(null);
        if(poste==null){
            return null;
        }
        return mapper.mapToDTO(poste);
    }
    
    public PosteDTO update(PosteDTO posteDTO) {
        Poste poste = mapper.mapTo(posteDTO);
        posteRepository.save(poste);
        return mapper.mapToDTO(poste);

    }
    
    public List<PosteDTO> getAll(){

        List<Poste> postes = posteRepository.findAll();
        return mapper.mapToDTO(postes);

    }

    public String delete(Long id){
        Poste poste = posteRepository.findById(id).orElse(null);
        if(poste==null){
            return null;
        }
        posteRepository.deleteById(id);

        return "Deleted";
    }

}
