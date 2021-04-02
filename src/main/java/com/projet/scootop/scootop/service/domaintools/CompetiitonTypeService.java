package com.projet.scootop.scootop.service.domaintools;

import com.projet.scootop.scootop.domain.domaintools.CompetitionType;
import com.projet.scootop.scootop.model.domainetools.CompetitionTypeDTO;
import com.projet.scootop.scootop.repository.domainetools.CompetitionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetiitonTypeService {
    @Autowired
    public CompetitionTypeRepository competionTypeRepository;
    public CompetitionType add(CompetitionTypeDTO competionTypeDTO){
        CompetitionType competionType=new CompetitionType(competionTypeDTO.name,competionTypeDTO.video,competionTypeDTO.playerMax,competionTypeDTO.playerMin,competionTypeDTO.titulaire,competionTypeDTO.remplacant,competionTypeDTO.substition,competionTypeDTO.time,competionTypeDTO.category);
        return competionTypeRepository.save(competionType);

    }
    public CompetitionType get(Integer id){
        return competionTypeRepository.findById(id).orElse(null);
    }
    public CompetitionType update(CompetitionTypeDTO competionTypeDTO, Integer id){
        CompetitionType competionType=new CompetitionType(competionTypeDTO.name,competionTypeDTO.video,competionTypeDTO.playerMax,competionTypeDTO.playerMin,competionTypeDTO.titulaire,competionTypeDTO.remplacant,competionTypeDTO.substition,competionTypeDTO.time,competionTypeDTO.category);
        competionType.id=id;
        return competionTypeRepository.save(competionType);
    }
    public CompetitionType updateEntity(CompetitionType competionType){
        return competionTypeRepository.save(competionType);
    }
    public List<CompetitionType> getAll(){

        return competionTypeRepository.findAll();

    }
    public String delete(Integer id){
        CompetitionType competionType = competionTypeRepository.findById(id).orElse(null);
        if(competionType==null){
            return null;
        }
        competionTypeRepository.deleteById(id);

        return "Deleted";
    }
}
