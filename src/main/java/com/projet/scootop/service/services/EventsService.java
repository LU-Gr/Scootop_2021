package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.Event;
import com.projet.scootop.mappers.services.EventMapper;
import com.projet.scootop.model.services.EventDTO;
import com.projet.scootop.repository.services.EventsRepository;
import com.projet.scootop.repository.services.tools.video.VideoRepository;
import com.projet.scootop.repository.tools.CompetitionRepository;
import com.projet.scootop.repository.tools.SaisonRepository;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.domainuser.ScootRepository;

import java.util.List;

@Service
public class EventsService {

    @Autowired private EventsRepository eventsRepository;
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
        eventsRepository.save(events);
        return mapper.mapToDTO(events);
    }
    
    public EventDTO get(Long id){
        Event events = eventsRepository.findById(id).orElse(null);

        if(events==null){
            return null;
        }

        return mapper.mapToDTO(events);

    }

    public EventDTO update(EventDTO eventsDTO, Long id){
        Event events = mapper.mapTo(eventsDTO);
        eventsRepository.save(events);
        return mapper.mapToDTO(events);
    }

    public List<EventDTO> getAll(){

        List <Event> events = eventsRepository.findAll();
        return mapper.mapToDTO(events);

    }

    public String delete(Long id){
        eventsRepository.deleteById(id);

        return "Deleted";
    }    
}
