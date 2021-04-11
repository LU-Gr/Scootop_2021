package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.GameSheet;
import com.projet.scootop.mappers.services.GameSheetMapper;
import com.projet.scootop.model.services.GameSheetDTO;
import com.projet.scootop.repository.domainconfiguration.StadeRepository;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.inprogress.StatisticalSheetRepository;
import com.projet.scootop.repository.services.EventsRepository;
import com.projet.scootop.repository.services.GameSheetRepository;
import com.projet.scootop.repository.user.UserRepository;

import java.util.List;

@Service
public class GameSheetService {
	
    @Autowired private GameSheetRepository gameSheetRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private StatisticalSheetRepository statisticalSheetRepository;
    @Autowired private StadeRepository stadeRepository;
    @Autowired private EventsRepository eventsRepository;
    @Autowired private GameSheetMapper mapper;

    public GameSheetDTO addGameSheet(GameSheetDTO gameSheetDTO) {
    	GameSheet gamesheet = mapper.mapTo(gameSheetDTO);
        userRepository.save(gamesheet.getUser());
        teamRepository.saveAll(gamesheet.getTeams());
        statisticalSheetRepository.saveAll(gamesheet.getStactisticalSheets());
        stadeRepository.save(gamesheet.getStade());
        eventsRepository.save(gamesheet.getEvents());
        gameSheetRepository.save(gamesheet);
        return mapper.mapTo(gamesheet);
    }
    
    public GameSheetDTO get(Long id){
        GameSheet gameSheet = gameSheetRepository.findById(id).orElse(null);
        if(gameSheet==null){
            return null;
        }

        return mapper.mapTo(gameSheet);
    }

    public List<GameSheetDTO> getAll(){

        List<GameSheet> gameSheets = gameSheetRepository.findAll();
        return mapper.mapTo(gameSheets);
    }

    public String delete(Long id){
        GameSheet gameSheet = gameSheetRepository.findById(id).orElse(null);
        if(gameSheet==null){
            return null;
        }
        gameSheetRepository.deleteById(id);

        return "Deleted";
    }
}
