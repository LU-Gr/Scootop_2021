package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.mappers.tools.SaisonMapper;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.repository.tools.SaisonRepository;

import java.util.List;

@Service
public class SaisonService {
	
    @Autowired private SaisonRepository saisonRepository;
    @Autowired private SaisonMapper mapper;
    
    public SaisonDTO add(SaisonDTO saisonDTO) {
        Saison saison = mapper.mapTo(saisonDTO);
        saisonRepository.save(saison);
        return mapper.mapToDTO(saison);
    }
    public SaisonDTO get(Long id){

        Saison saison = saisonRepository.findById(id).orElse(null);
        if(saison == null){
            return null;
        }

        return mapper.mapToDTO(saison);
    }

    public List<SaisonDTO> getAll(){

        List<Saison> saisons = saisonRepository.findAll();
        return mapper.mapToDTO(saisons);
        
    }


    public String delete(Long id){
        Saison saison = saisonRepository.findById(id).orElse(null);
        if(saison == null){
            return null;
        }
        saisonRepository.deleteById(id);

        return "Deleted";
    }

}
