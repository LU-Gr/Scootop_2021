package com.projet.scootop.scootop.service.services;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domaintools.CompetitionType;
import com.projet.scootop.scootop.domain.domaintools.Saison;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.services.GameSheet;
import com.projet.scootop.scootop.domain.services.Wearable;
import com.projet.scootop.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.scootop.model.inprogress.MatchSheetDTO;
import com.projet.scootop.scootop.model.services.GameSheetDTO;
import com.projet.scootop.scootop.model.services.WearableDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.scootop.repository.services.WearableRepository;
import com.projet.scootop.scootop.servicetools.videosservices.Video;
import com.projet.scootop.scootop.user.User;
import org.h2.api.TimestampWithTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
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

    public WearableDTO get(Integer id){

        Wearable wearable = wearableRepository.findById(id).orElse(null);
        if(wearable==null){
            return null;
        }

        return WearableDTO.get(wearable.id, wearable.player, wearable.team,wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill);
    }

    public WearableDTO getOneByMatchSheetAndTeamAndPlayer(int matchsheetId,int teamId, int playersId){


        Wearable wearable = wearableRepository.findByMatchSheetAndTeamAndPlayer(matchsheetId,teamId,playersId);
        if(wearable==null){
            return null;
        }

        return WearableDTO.get(wearable.id, wearable.player, wearable.team,wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill);
    }

    public Wearable update(WearableDTO wearableDTO,Integer id){
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

    public List<WearableDTO> getAllByMatcSheetId(int matchSheet){

        List<Wearable> wearables = wearableRepository.findAllById(matchSheet);
        return wearables.stream().map(wearable -> WearableDTO.get(wearable.id, wearable.player, wearable.team, wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill)).collect(Collectors.toList());

    }

    public List<WearableDTO> getAllByMatchSheetAndTeam(int matchSheet, int team){

        List<Wearable> wearables = wearableRepository.findAllByMatchSheetAndTeam(matchSheet,team);
        return wearables.stream().map(wearable -> WearableDTO.get(wearable.id, wearable.player, wearable.team, wearable.distanceRun,wearable.distancePlay,wearable.vMax,wearable.vMaxWithBall,wearable.ballPlay,wearable.looseBall,wearable.ballRecovered,wearable.tackle,wearable.foulSuffered,wearable.failPass,wearable.assist,wearable.shortPass,wearable.head,wearable.headOffensive,wearable.headDefensive,wearable.shots,wearable.shotOnTarget,wearable.shotOffTarget,wearable.longShot,wearable.successSkill,wearable.failSkill)).collect(Collectors.toList());

    }


    public String delete(Integer id){
        wearableRepository.deleteById(id);

        return "Deleted";
    }
}
