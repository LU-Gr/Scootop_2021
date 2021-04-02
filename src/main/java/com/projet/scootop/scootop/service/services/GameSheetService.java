package com.projet.scootop.scootop.service.services;

import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.domain.services.GameSheet;
import com.projet.scootop.scootop.domain.services.Shortlist;
import com.projet.scootop.scootop.model.services.GameSheetDTO;
import com.projet.scootop.scootop.model.services.ShortlistDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.StadeRepository;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.scootop.repository.services.EventsRepository;
import com.projet.scootop.scootop.repository.services.GameSheetRepository;
import com.projet.scootop.scootop.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameSheetService {
    @Autowired
    public GameSheetRepository gameSheetRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public TeamRepository teamRepository;
    @Autowired
    public StatisticalSheetRepository statisticalSheetRepository;

    @Autowired
    public StadeRepository stadeRepository;

    @Autowired
    public EventsRepository eventsRepository;

    public GameSheetDTO addGameSheet(GameSheetDTO gameSheetDTO) {

        userRepository.save(gameSheetDTO.user);
        teamRepository.saveAll(gameSheetDTO.teams);
        statisticalSheetRepository.saveAll(gameSheetDTO.stactisticalSheets);
        stadeRepository.save(gameSheetDTO.stade);
        eventsRepository.save(gameSheetDTO.events);

        GameSheet gamesheet = new GameSheet(gameSheetDTO.user, gameSheetDTO.teams, gameSheetDTO.stactisticalSheets, gameSheetDTO.stade, gameSheetDTO.events, gameSheetDTO.date);
        gameSheetRepository.save(gamesheet);

        return gameSheetDTO;
    }
    public GameSheetDTO get(Integer id){

        GameSheet gameSheet = gameSheetRepository.findById(id).orElse(null);
        if(gameSheet==null){
            return null;
        }

        return GameSheetDTO.get(gameSheet.id, gameSheet.user, gameSheet.teams, gameSheet.stactisticalSheets, gameSheet.stade, gameSheet.events, gameSheet.date);
    }

    public List<GameSheetDTO> getAll(){

        List<GameSheet> gameSheets = gameSheetRepository.findAll();
        return gameSheets.stream().map(gameSheet -> GameSheetDTO.get(gameSheet.id, gameSheet.user, gameSheet.teams, gameSheet.stactisticalSheets, gameSheet.stade, gameSheet.events, gameSheet.date)).collect(Collectors.toList());
    }


    public String delete(Integer id){
        GameSheet gameSheet = gameSheetRepository.findById(id).orElse(null);
        if(gameSheet==null){
            return null;
        }
        gameSheetRepository.deleteById(id);

        return "Deleted";
    }
}
