package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.Wearable;
import com.projet.scootop.mappers.services.WearableMapper;
import com.projet.scootop.model.services.WearableDTO;
import com.projet.scootop.repository.services.WearableRepository;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.domainuser.PlayerRepository;

import java.util.*;

@Service
public class WearableService {
	
    @Autowired private WearableRepository wearableRepository;
    @Autowired private PlayerRepository playerRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private WearableMapper mapper;

    public WearableDTO add(WearableDTO wearableDTO){
    	Wearable wearable = mapper.mapTo(wearableDTO);
        playerRepository.save(wearable.getPlayer());
        teamRepository.save(wearable.getTeam());
        wearableRepository.save(wearable);
        return mapper.mapTo(wearable);
    }

    public WearableDTO get(Long id){
        Wearable wearable = wearableRepository.findById(id).orElse(null);
        if(wearable==null){
            return null;
        }
        return mapper.mapTo(wearable);
    }

    public WearableDTO getOneByMatchSheetAndTeamAndPlayer(Long matchsheetId,Long teamId, Long playersId){
        Wearable wearable = wearableRepository.findByMatchSheetAndTeamAndPlayer(matchsheetId,teamId,playersId);
        if(wearable==null){
            return null;
        }
        return mapper.mapTo(wearable);
    }

    public Wearable update(WearableDTO wearableDTO, Long id){
    	Wearable wearable = mapper.mapTo(wearableDTO);
        playerRepository.save(wearable.getPlayer());
        teamRepository.save(wearable.getTeam());
        wearableRepository.save(wearable);
        return mapper.mapTo(wearableDTO);
    }

    public List<WearableDTO> getAll(){
        List<Wearable> wearables = wearableRepository.findAll();
        return mapper.mapTo(wearables);
    }

    public List<WearableDTO> getAllByMatchSheetId(Long matchSheet){
        List<Wearable> wearables = wearableRepository.findAllById(matchSheet);
        return mapper.mapTo(wearables);
    }

    public List<WearableDTO> getAllByMatchSheetAndTeam(Long matchSheet, Long team){
        List<Wearable> wearables = wearableRepository.findAllByMatchSheetAndTeam(matchSheet,team);
        return mapper.mapTo(wearables);
    }


    public String delete(Long id){
        wearableRepository.deleteById(id);

        return "Deleted";
    }
}
