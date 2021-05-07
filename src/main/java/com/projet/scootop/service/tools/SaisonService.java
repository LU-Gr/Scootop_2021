package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Saison;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.repository.tools.SaisonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaisonService {
    @Autowired
    public SaisonRepository saisonRepository;
    public SaisonDTO addSaison(SaisonDTO saisonDTO) {
        Saison saison = new Saison(saisonDTO.getDateDebut(),saisonDTO.getDateFin(),saisonDTO.getMatchSheets());
        saisonRepository.save(saison);
        return saisonDTO;
    }
    public SaisonDTO get(Long id){

        Saison saison = saisonRepository.findById(id).orElse(null);
        if(saison==null){
            return null;
        }

        return SaisonDTO.get(saison.getId(),saison.getDateDebut(),saison.getDateFin(),saison.getMatchSheets());
    }

    public List<SaisonDTO> getAll(){

        List<Saison> saisons = saisonRepository.findAll();
        return saisons.stream().map(saison -> SaisonDTO.get(saison.getId(),saison.getDateDebut(),saison.getDateFin(),saison.getMatchSheets())).collect(Collectors.toList());
    }


    public String delete(Long id){
        Saison scoot = saisonRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        saisonRepository.deleteById(id);

        return "Deleted";
    }

}
