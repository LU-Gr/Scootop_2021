package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Division;
import com.projet.scootop.scootop.domain.domainconfiguration.League;
import com.projet.scootop.scootop.model.domainconfiguration.DivisionsDTO;
import com.projet.scootop.scootop.model.domainconfiguration.DivisionsDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.DivisionsRepository;
import com.projet.scootop.scootop.repository.domainconfiguration.DivisionsRepository;
import com.projet.scootop.scootop.repository.domainconfiguration.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DivisionsService {
    @Autowired
    public DivisionsRepository divisionsRepository;
    @Autowired
    public LeagueRepository leagueRepository;
    public DivisionsDTO add(DivisionsDTO divisionsDTO,Integer id){
        League leagues=leagueRepository.findById(id).orElse(null);
        Division newDivision = new Division(divisionsDTO.name);
        leagues.divisions.add(newDivision);
        divisionsRepository.save(newDivision);
        return divisionsDTO;
    }
    public DivisionsDTO get(Integer id){

        Division divisions = divisionsRepository.findById(id).orElse(null);
        if(divisions==null){
            return null;
        }
        return DivisionsDTO.create(divisions.name);
    }
    public List<DivisionsDTO> getAll(){

        List<Division> divisionsList = divisionsRepository.findAll();
        return divisionsList.stream().map(divisions -> DivisionsDTO.create(divisions.name)).collect(Collectors.toList());
    }
    public String delete(Integer id){
        Division divisions = divisionsRepository.findById(id).orElse(null);
        if(divisions==null){
            return null;
        }
        divisionsRepository.deleteById(id);

        return "Deleted";
    }

}
