package com.projet.scootop.service.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.CategoryType;
import com.projet.scootop.domain.configuration.CompetitionType;
import com.projet.scootop.mappers.configuration.CompetitionTypeMapper;
import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import com.projet.scootop.repository.configuration.CompetitionTypeRepository;

@Service
public class CompetitionTypeService {
	
    @Autowired private CompetitionTypeRepository competitionTypeRepository;
    @Autowired private CompetitionTypeMapper mapper;
    
    public CompetitionTypeDTO add(CompetitionTypeDTO categorieDTO){
    	CompetitionType categorieType = mapper.mapTo(categorieDTO);
    	competitionTypeRepository.save(categorieType);
        return mapper.mapToDTO(categorieType);

    }
    public CompetitionTypeDTO update(CompetitionTypeDTO categorieDTO){
    	CompetitionType categorieType = mapper.mapTo(categorieDTO);
    	competitionTypeRepository.save(categorieType);
        return mapper.mapToDTO(categorieType);

    }
    public CompetitionTypeDTO get(Long id){
    	CompetitionType ct = competitionTypeRepository.findById(id).orElse(null);
        return mapper.mapToDTO(ct);

    }
    public List<CompetitionTypeDTO> getAll(){
    	List<CompetitionType> cts = competitionTypeRepository.findAll();
        return mapper.mapToDTO(cts);
    }
    public String delete(Long id){
    	CompetitionType categorie = competitionTypeRepository.findById(id).orElse(null);
        if(categorie==null){
            return null;
        }
        competitionTypeRepository.deleteById(id);

        return "Deleted";
    }

}
