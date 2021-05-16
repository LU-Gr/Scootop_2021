package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.Event;
import com.projet.scootop.mappers.services.EventMapper;
import com.projet.scootop.model.services.EventDTO;
import com.projet.scootop.repository.services.EventRepository;
import com.projet.scootop.repository.services.tools.video.VideoRepository;
import com.projet.scootop.repository.tools.CompetitionRepository;
import com.projet.scootop.repository.tools.SaisonRepository;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.domain.ScootRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired private EventRepository eventRepository;
    @Autowired private SaisonRepository saisonRepository;
    @Autowired private VideoRepository videoRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private ScootRepository scootRepository;
    @Autowired private CompetitionRepository competitiontypeRepository;
    @Autowired private EventMapper mapper;


    public EventDTO addEvent(EventDTO eventsDTO){
    	Event events = mapper.mapTo(eventsDTO);
        saisonRepository.save(events.getSaison());
        competitiontypeRepository.save(events.getCompetition());
        videoRepository.saveAll(events.getVideos());
        scootRepository.saveAll(events.getScoots());
        teamRepository.saveAll(events.getTeams());
        eventRepository.save(events);
        return mapper.mapToDTO(events);
    }
    
    public EventDTO get(Long id){
        Event events = eventRepository.findById(id).orElse(null);

        if(events==null){
            return null;
        }

        return mapper.mapToDTO(events);

    }

    public EventDTO update(EventDTO eventsDTO){
        Event events = mapper.mapTo(eventsDTO);
        eventRepository.save(events);
        return mapper.mapToDTO(events);
    }

    public List<EventDTO> getAll(){

        List <Event> events = eventRepository.findAll();
        return mapper.mapToDTO(events);

    }

    public String delete(Long id){
        eventRepository.deleteById(id);

        return "Deleted";
    }    
}
