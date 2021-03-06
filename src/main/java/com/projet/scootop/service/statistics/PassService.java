package com.projet.scootop.service.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistics.Pass;
import com.projet.scootop.mappers.statistics.PassMapper;
import com.projet.scootop.model.statistics.PassDTO;
import com.projet.scootop.repository.statistics.PassRepository;
import com.projet.scootop.repository.tools.MatchRepository;

import java.util.List;

@Service
public class PassService {
	
	@Autowired private PassRepository assistRepository;
    @Autowired private MatchRepository matchSheetRepository;
    @Autowired private PassMapper mapper;

    public PassDTO add(PassDTO passDTO){
        Pass pass = mapper.mapTo(passDTO);
        matchSheetRepository.save(pass.getMatch());
        assistRepository.save(pass);
        return mapper.mapToDTO(pass);
    }
    
    public PassDTO get(Long id){
    	Pass pass = assistRepository.findById(id).orElse(null);
        return mapper.mapToDTO(pass);
    }
    
    public PassDTO update(PassDTO passDTO){
        Pass pass = mapper.mapTo(passDTO);
        matchSheetRepository.save(pass.getMatch());
        assistRepository.save(pass);
        return mapper.mapToDTO(pass);
    }
    
    public List<PassDTO> getAll(){
    	List<Pass> passes = assistRepository.findAll();
        return mapper.mapToDTO(passes);
    }
    
    public String delete(Long id){
        assistRepository.deleteById(id);
        return "Deleted";
    }
}
