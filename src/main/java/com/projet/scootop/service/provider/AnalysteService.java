package com.projet.scootop.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.provider.Analyste;
import com.projet.scootop.model.provider.AnalysteDTO;
import com.projet.scootop.repository.provider.AnalysteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalysteService {
	
    @Autowired
    public AnalysteRepository analysteRepository;
    
    public AnalysteDTO add(AnalysteDTO analysteDTO) throws Exception {
        Analyste analyste=new Analyste(analysteDTO.user,analysteDTO.tarif,analysteDTO.experience,analysteDTO.matchSheet);
        analysteRepository.save(analyste);
        return analysteDTO;
    }
    
    public AnalysteDTO get(Long id){

        Analyste analyste = analysteRepository.findById(id).orElse(null);
        if(analyste==null){
            return null;
        }
        AnalysteDTO analysteDTO = AnalysteDTO.create(analyste.user,analyste.tarif,analyste.experience,analyste.matchSheet);
        return analysteDTO;
    }
    
    public List<AnalysteDTO> getAll(){

        List<Analyste> chairmen = analysteRepository.findAll();
        List<AnalysteDTO> analysteDTOS = new ArrayList<>();
        for (Analyste analyste: chairmen) {
            AnalysteDTO analysteDTO= AnalysteDTO.get(analyste.id,analyste.user,analyste.tarif,analyste.experience,analyste.matchSheet);
            analysteDTOS.add(analysteDTO);
        }

        return analysteDTOS;
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
