package com.projet.scootop.scootop.service.services;

import com.projet.scootop.scootop.domain.services.Events;
import com.projet.scootop.scootop.model.services.EventsDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.domainetools.CompetitionRepository;
import com.projet.scootop.scootop.repository.domainetools.SaisonRepository;
import com.projet.scootop.scootop.repository.domainuser.ScootRepository;
import com.projet.scootop.scootop.repository.services.EventsRepository;
import com.projet.scootop.scootop.repository.services.GameSheetRepository;
import com.projet.scootop.scootop.repository.servicetools.videosservices.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventsService {

    @Autowired
    public EventsRepository eventsRepository;
    @Autowired
    public SaisonRepository saisonRepository;
    @Autowired
    public VideoRepository videoRepository;
    @Autowired
    public TeamRepository teamRepository;
    @Autowired
    public ScootRepository scootRepository;
    @Autowired
    public CompetitionRepository competitiontypeRepository;
    @Autowired
    public GameSheetRepository gameSheetRepository;


    public EventsDTO addEvent(EventsDTO eventsDTO){

        saisonRepository.save(eventsDTO.saison);
        competitiontypeRepository.save(eventsDTO.competitiontype);
        videoRepository.saveAll(eventsDTO.videos);
        gameSheetRepository.saveAll(eventsDTO.gameSheets);
        scootRepository.saveAll(eventsDTO.scoots);
        teamRepository.saveAll(eventsDTO.teams);

        Events events = new Events(eventsDTO.id,eventsDTO.date, eventsDTO.competitiontype,eventsDTO.teams, eventsDTO.scoots, eventsDTO.gameSheets, eventsDTO.status,eventsDTO.prestaAnalyst,eventsDTO.prestaCameraman,eventsDTO.prestaWearable,eventsDTO.prestaScoot,eventsDTO.prestaZoom,eventsDTO.saison,eventsDTO.videos);
        eventsRepository.save(events);

        return eventsDTO;

    }
    public EventsDTO get(Long id){

        Events events = eventsRepository.findById(id).orElse(null);

        if(events==null){
            return null;
        }

        return EventsDTO.get(events.id,events.date, events.competitiontype,events.teams, events.scoots, events.gameSheets, events.status,events.prestaAnalyst,events.prestaCameraman,events.prestaWearable,events.prestaScoot,events.prestaZoom,events.saison,events.videos);

    }

    public Events update(EventsDTO eventsDTO, Long id){
        Events events = new Events(eventsDTO.id, eventsDTO.date, eventsDTO.competitiontype,eventsDTO.teams, eventsDTO.scoots, eventsDTO.gameSheets, eventsDTO.status,eventsDTO.prestaAnalyst,eventsDTO.prestaCameraman,eventsDTO.prestaWearable,eventsDTO.prestaScoot,eventsDTO.prestaZoom,eventsDTO.saison,eventsDTO.videos);
        events.id=id;
        return eventsRepository.save(events);
    }

    public List<EventsDTO> getAll(){

        List <Events> events = eventsRepository.findAll();
        return events.stream().map(event -> EventsDTO.get(event.id,event.date, event.competitiontype,event.teams, event.scoots, event.gameSheets, event.status,event.prestaAnalyst,event.prestaCameraman,event.prestaWearable,event.prestaScoot,event.prestaZoom,event.saison,event.videos)).collect(Collectors.toList());

    }

    public String delete(Long id){
        eventsRepository.deleteById(id);

        return "Deleted";
    }    
}
