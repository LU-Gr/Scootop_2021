package com.projet.scootop.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.LocationWearable;
import com.projet.scootop.mappers.services.LocationWearableMapper;
import com.projet.scootop.model.services.LocationWearableDTO;
import com.projet.scootop.repository.services.LocationWearableRepository;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.domain.PlayerRepository;

@Service
public class LocationWearableService {
	
	@Autowired private LocationWearableRepository wearableRepository;
    @Autowired private PlayerRepository playerRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private LocationWearableMapper mapper;

    public LocationWearableDTO add(LocationWearableDTO wearableDTO){
    	LocationWearable wearable = mapper.mapTo(wearableDTO);
        playerRepository.save(wearable.getPlayer());
        teamRepository.save(wearable.getTeam());
        wearableRepository.save(wearable);
        return mapper.mapToDTO(wearable);
    }

    public LocationWearableDTO get(Long id){
    	LocationWearable wearable = wearableRepository.findById(id).orElse(null);
        if(wearable==null){
            return null;
        }
        return mapper.mapToDTO(wearable);
    }

    public LocationWearableDTO getOneByMatchSheetAndTeamAndPlayer(Long matchsheetId,Long teamId, Long playersId){
    	LocationWearable wearable = wearableRepository.findByMatchAndTeamAndPlayer(matchsheetId,teamId,playersId);
        if(wearable==null){
            return null;
        }
        return mapper.mapToDTO(wearable);
    }

    public LocationWearableDTO update(LocationWearableDTO wearableDTO){
    	LocationWearable wearable = mapper.mapTo(wearableDTO);
        playerRepository.save(wearable.getPlayer());
        teamRepository.save(wearable.getTeam());
        wearableRepository.save(wearable);
        return mapper.mapToDTO(wearable);
    }

    public List<LocationWearableDTO> getAll(){
        List<LocationWearable> wearables = wearableRepository.findAll();
        return mapper.mapToDTO(wearables);
    }

    public List<LocationWearableDTO> getAllByMatchSheetAndTeam(Long matchSheet, Long team){
        List<LocationWearable> wearables = wearableRepository.findAllByMatchAndTeam(matchSheet,team);
        return mapper.mapToDTO(wearables);
    }


    public String delete(Long id){
        wearableRepository.deleteById(id);

        return "Deleted";
    }

}
