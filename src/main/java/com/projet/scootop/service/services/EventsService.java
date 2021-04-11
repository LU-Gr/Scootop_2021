package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.Events;
import com.projet.scootop.mappers.services.EventsMapper;
import com.projet.scootop.model.services.EventsDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainetools.CompetitionRepository;
import com.projet.scootop.repository.domainetools.SaisonRepository;
import com.projet.scootop.repository.domainuser.ScootRepository;
import com.projet.scootop.repository.services.EventsRepository;
import com.projet.scootop.repository.services.GameSheetRepository;
import com.projet.scootop.repository.servicetools.video.VideoRepository;

import java.util.List;

@Service
public class EventsService {

    @Autowired private EventsRepository eventsRepository;
    @Autowired private SaisonRepository saisonRepository;
    @Autowired private VideoRepository videoRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private ScootRepository scootRepository;
    @Autowired private CompetitionRepository competitiontypeRepository;
    @Autowired private GameSheetRepository gameSheetRepository;
    @Autowired private EventsMapper mapper;


    public EventsDTO addEvent(EventsDTO eventsDTO){
    	Events events = mapper.mapTo(eventsDTO);
        saisonRepository.save(events.getSaison());
        competitiontypeRepository.save(events.getCompetition());
        videoRepository.saveAll(events.getVideos());
        gameSheetRepository.saveAll(events.getGameSheets());
        scootRepository.saveAll(events.getScoots());
        teamRepository.saveAll(events.getTeams());
        eventsRepository.save(events);
        return mapper.mapTo(events);
    }
    
    public EventsDTO get(Long id){
        Events events = eventsRepository.findById(id).orElse(null);

        if(events==null){
            return null;
        }

        return mapper.mapTo(events);

    }

    public Events update(EventsDTO eventsDTO, Long id){
        Events events = mapper.mapTo(eventsDTO);
        eventsRepository.save(events);
        return mapper.mapTo(eventsDTO);
    }

    public List<EventsDTO> getAll(){

        List <Events> events = eventsRepository.findAll();
        return mapper.mapTo(events);

    }

    public String delete(Long id){
        eventsRepository.deleteById(id);

        return "Deleted";
    }    
}
