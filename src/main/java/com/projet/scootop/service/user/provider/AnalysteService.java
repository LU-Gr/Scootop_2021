package com.projet.scootop.service.user.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.provider.Analyste;
import com.projet.scootop.mappers.user.provider.AnalysteMapper;
import com.projet.scootop.model.user.provider.AnalysteDTO;
import com.projet.scootop.repository.user.provider.AnalysteRepository;

import java.util.List;

@Service
public class AnalysteService {
	
    @Autowired
    public AnalysteRepository analysteRepository;
    
    @Autowired
    private AnalysteMapper mapper;
    
    public AnalysteDTO add(AnalysteDTO analysteDTO) throws Exception {
        Analyste analyste = mapper.mapTo(analysteDTO);
        analysteRepository.save(analyste);
        return mapper.mapTo(analyste);
    }
    
    public AnalysteDTO get(Long id){
        Analyste analyste = analysteRepository.findById(id).orElse(null);
        if(analyste==null){
            return null;
        }
        return mapper.mapTo(analyste);
    }
    
    public List<AnalysteDTO> getAll(){
        List<Analyste> analystes = analysteRepository.findAll();
        return mapper.mapTo(analystes);
    }
    
    public String delete(Long id){
        Analyste analyste = analysteRepository.findById(id).orElse(null);
        if(analyste==null){
            return null;
        }
        analysteRepository.deleteById(id);

        return "Deleted";
    }

}
