package com.projet.scootop.service.statistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.Pass;
import com.projet.scootop.mappers.statistical.PassMapper;
import com.projet.scootop.model.statistical.PassDTO;
import com.projet.scootop.repository.inprogress.MatchSheetRepository;
import com.projet.scootop.repository.statistical.PassRepository;

import java.util.List;

@Service
public class PassService {
	
	@Autowired private PassRepository assistRepository;
    @Autowired private MatchSheetRepository matchSheetRepository;
    @Autowired private PassMapper mapper;

    public PassDTO add(PassDTO passDTO){
        Pass pass = mapper.mapTo(passDTO);
        matchSheetRepository.save(pass.getMatchSheet());
        assistRepository.save(pass);
        return mapper.mapTo(pass);
    }
    
    public PassDTO get(Long id){
    	Pass pass = assistRepository.findById(id).orElse(null);
        return mapper.mapTo(pass);
    }
    
    public PassDTO update(PassDTO passDTO){
        Pass pass = mapper.mapTo(passDTO);
        matchSheetRepository.save(pass.getMatchSheet());
        assistRepository.save(pass);
        return mapper.mapTo(pass);
    }
    
    public List<PassDTO> getAll(){
    	List<Pass> passes = assistRepository.findAll();
        return mapper.mapTo(passes);
    }
    
    public String delete(Long id){
        assistRepository.deleteById(id);
        return "Deleted";
    }
}
