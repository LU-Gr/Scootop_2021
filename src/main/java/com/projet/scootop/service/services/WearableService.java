package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.Wearable;
import com.projet.scootop.model.services.WearableDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.repository.services.WearableRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WearableService {
	
    @Autowired
    public WearableRepository wearableRepository;
    
    @Autowired
    public PlayerRepository playerRepository;

    @Autowired
    public TeamRepository teamRepository;

    public WearableDTO add(WearableDTO wearableDTO){

        playerRepository.save(wearableDTO.player);
        teamRepository.save(wearableDTO.team);
        Wearable wearable = new Wearable(wearableDTO.player, wearableDTO.team, wearableDTO.matchSheet, wearableDTO.distanceRun,wearableDTO.distancePlay,wearableDTO.vMax,wearableDTO.vMaxWithBall,wearableDTO.ballPlay,wearableDTO.looseBall,wearableDTO.ballRecovered,wearableDTO.tackle,wearableDTO.foulSuffered,wearableDTO.failPass,wearableDTO.assist,wearableDTO.shortPass,wearableDTO.head,wearableDTO.headOffensive,wearableDTO.headDefensive,wearableDTO.shots,wearableDTO.shotOnTarget,wearableDTO.shotOffTarget,wearableDTO.longShot,wearableDTO.successSkill,wearableDTO.failSkill);
        wearableRepository.save(wearable);

        return wearableDTO;
    }

    public WearableDTO get(Long id){

        Wearable wearable = wearableRepository.findById(id).orElse(null);
        if(wearable==null){
            return null;
        }

        return WearableDTO.get(wearable.id, wearable.player, wearable.team,wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill);
    }

    public WearableDTO getOneByMatchSheetAndTeamAndPlayer(Long matchsheetId,Long teamId, Long playersId){


        Wearable wearable = wearableRepository.findByMatchSheetAndTeamAndPlayer(matchsheetId,teamId,playersId);
        if(wearable==null){
            return null;
        }

        return WearableDTO.get(wearable.id, wearable.player, wearable.team,wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill);
    }

    public Wearable update(WearableDTO wearableDTO, Long id){
        playerRepository.save(wearableDTO.player);

        teamRepository.save(wearableDTO.team);
        Wearable wearable = new Wearable(wearableDTO.player, wearableDTO.team, wearableDTO.matchSheet, wearableDTO.distanceRun,wearableDTO.distancePlay,wearableDTO.vMax,wearableDTO.vMaxWithBall,wearableDTO.ballPlay,wearableDTO.looseBall,wearableDTO.ballRecovered,wearableDTO.tackle,wearableDTO.foulSuffered,wearableDTO.failPass,wearableDTO.assist,wearableDTO.shortPass,wearableDTO.head,wearableDTO.headOffensive,wearableDTO.headDefensive,wearableDTO.shots,wearableDTO.shotOnTarget,wearableDTO.shotOffTarget,wearableDTO.longShot,wearableDTO.successSkill,wearableDTO.failSkill);
        wearable.id=id;
        return wearableRepository.save(wearable);
    }

    public List<WearableDTO> getAll(){
        List<Wearable> wearables = wearableRepository.findAll();
        return wearables.stream().map(wearable -> WearableDTO.get(wearable.id, wearable.player, wearable.team, wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill)).collect(Collectors.toList());

    }

    public List<WearableDTO> getAllByMatchSheetId(Long matchSheet){

        List<Wearable> wearables = wearableRepository.findAllById(matchSheet);
        return wearables.stream().map(wearable -> WearableDTO.get(wearable.id, wearable.player, wearable.team, wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill)).collect(Collectors.toList());

    }

    public List<WearableDTO> getAllByMatchSheetAndTeam(Long matchSheet, Long team){

        List<Wearable> wearables = wearableRepository.findAllByMatchSheetAndTeam(matchSheet,team);
        return wearables.stream().map(wearable -> WearableDTO.get(wearable.id, wearable.player, wearable.team, wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill)).collect(Collectors.toList());

    }


    public String delete(Long id){
        wearableRepository.deleteById(id);

        return "Deleted";
    }
}
