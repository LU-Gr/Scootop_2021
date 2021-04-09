package com.projet.scootop.scootop.service.domaintools;

import com.projet.scootop.scootop.domain.domaintools.Competition;
import com.projet.scootop.scootop.model.domaintools.CompetitionDTO;
import com.projet.scootop.scootop.repository.domainetools.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    public CompetitionRepository competionTypeRepository;
    public Competition add(CompetitionDTO competionTypeDTO){
        Competition competionType=new Competition(competionTypeDTO.name,competionTypeDTO.video,competionTypeDTO.playerMax,competionTypeDTO.playerMin,competionTypeDTO.titulaire,competionTypeDTO.remplacant,competionTypeDTO.substition,competionTypeDTO.time,competionTypeDTO.category);
        return competionTypeRepository.save(competionType);

    }
    public Competition get(Long id){
        return competionTypeRepository.findById(id).orElse(null);
    }
    public Competition update(CompetitionDTO competionTypeDTO, Long id){
        Competition competionType= new Competition(competionTypeDTO.name,competionTypeDTO.video,competionTypeDTO.playerMax,competionTypeDTO.playerMin,competionTypeDTO.titulaire,competionTypeDTO.remplacant,competionTypeDTO.substition,competionTypeDTO.time,competionTypeDTO.category);
        competionType.id=id;
        return competionTypeRepository.save(competionType);
    }
    public Competition updateEntity(Competition competionType){
        return competionTypeRepository.save(competionType);
    }
    public List<Competition> getAll(){

        return competionTypeRepository.findAll();

    }
    public String delete(Long id){
        Competition competionType = competionTypeRepository.findById(id).orElse(null);
        if(competionType==null){
            return null;
        }
        competionTypeRepository.deleteById(id);

        return "Deleted";
    }
}
