package com.projet.scootop.service.user.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.provider.Analyst;
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
        Analyst analyste = mapper.mapTo(analysteDTO);
        analysteRepository.save(analyste);
        return mapper.mapToDTO(analyste);
    }
    
    public AnalysteDTO get(Long id){
        Analyst analyste = analysteRepository.findById(id).orElse(null);
        if(analyste==null){
            return null;
        }
        return mapper.mapToDTO(analyste);
    }
    
    public List<AnalysteDTO> getAll(){
        List<Analyst> analystes = analysteRepository.findAll();
        return mapper.mapToDTO(analystes);
    }
    
    public String delete(Long id){
        Analyst analyste = analysteRepository.findById(id).orElse(null);
        if(analyste==null){
            return null;
        }
        analysteRepository.deleteById(id);

        return "Deleted";
    }

}
