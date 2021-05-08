package com.projet.scootop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.model.services.*;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.model.user.domainuser.PlayerDTO;
import com.projet.scootop.model.user.domainuser.ScootDTO;
import com.projet.scootop.service.services.*;
import com.projet.scootop.service.tools.StatisticalSheetService;
import com.projet.scootop.service.user.domainuser.PlayerService;
import com.projet.scootop.service.user.domainuser.ScootService;

import java.util.*;

@RestController
public class ServicesController {

    @Autowired private ShortlistService  shortlistService;
    @Autowired private EventsService     eventsService;
    @Autowired private WearableService   wearableService;
    @Autowired private StatisticalSheetService statisticalSheetService;
    @Autowired private PlayerService playerService;
    @Autowired private ScootService scootService;
    
    // **** MatchSheet Data ****


    // **** MatchSheet Data return wearables by team ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/{TeamId}/wearables")
    @ResponseBody
    List<WearableDTO> getAllByWearablesByMatchSheetId(@PathVariable("matchsheetsId") Long matchId, @PathVariable("TeamId") Long teamId ){
    	return wearableService.getAllByMatchSheetAndTeam(matchId,teamId);
    }


    // **** MatchSheet Data return StatisticalSheet ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/stats")
    StatisticalSheetDTO getStatSheetByMatchSheet(@PathVariable("matchsheetsId") Long matchsheetId){
        return statisticalSheetService.getOneStatSheetByMatchSheet(matchsheetId);
    }

    // **** MatchSheet Data return One wearable in matchSheet Team wearables list by Team ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/{TeamId}/wearables/{playeurId}")
    WearableDTO getOneByMatchSheetAndTeamAndPlayer(@PathVariable("matchsheetsId") Long matchsheetId,@PathVariable("TeamId") Long teamId,@PathVariable("playeurId") Long playersId ){
        return wearableService.getOneByMatchSheetAndTeamAndPlayer(matchsheetId,teamId,playersId);
    }


    // **** MatchSheet Data return One wearable in game wearable list by id ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/wearables/{wearableId}")
    WearableDTO getGameWearable(@PathVariable("matchsheetsId") Long matchsheetId,@PathVariable("wearableId") Long id ){
        return wearableService.get(matchsheetId);
    }


    // **** MatchSheet Data return List of Avalaible Scoot ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/scoots")
    @ResponseBody
    List<ScootDTO> getAllByScootByMatchSheetId(@PathVariable("matchsheetsId") Long matchId){
        return scootService.getAllByMatchSheetId(matchId);
    }

    // **** MatchSheet Data return One Scoot ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/scoot/{id}")
    	ScootDTO getScoot(@PathVariable("id") Long id){
    	return scootService.get(id);
    }

    // **** MatchSheet Data return All Wearables ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/wearables")
    @ResponseBody
    List<WearableDTO> getAllByWearablesByMatchSheetId(@PathVariable("matchsheetsId") Long matchId){
    	return wearableService.getAllByMatchSheetId(matchId);
    }

    // **** Data return All Wearables ****
    @GetMapping("api/wearables")
    @ResponseBody
    List<WearableDTO> getAllWearable(){
    	return wearableService.getAll();
    }

    // **** Data return One Wearable By Id Wearables ****
    @GetMapping("api/wearable/{id}")
    WearableDTO getWearable(@PathVariable("id") Long id){
    	return wearableService.get(id);
    }


    // **** Data update One Wearable By Id Wearables ****
    @PutMapping("api/wearable/{id}")
    String updateWearable(@RequestBody String body, @PathVariable("id") Long id){
        String wearable = body;
        return wearable;
    }


    // **** Data post One Wearable By Id Wearables ****
    @PostMapping("api/wearable")
    WearableDTO addWearable(@RequestBody WearableDTO body){
        WearableDTO wearable = body;
        return wearable;
    }


    // **** Data delete One Wearable By Id Wearables ****
    @DeleteMapping("api/wearable/{id}")
    String deleteWearable(@PathVariable("id") Long id){
        return "deleted";
    }


    // **** Data list  of Shortlist ****
    @GetMapping("api/shortlists")
    @ResponseBody
    List<ShortlistDTO> getAllShortlist(){
    	return shortlistService.getAll();
    }


    // **** Data get one Shortlist by Id ****
    @GetMapping("api/shortlist/{id}")
    ShortlistDTO getUserShortlist(@PathVariable("id") Long id){
    	return shortlistService.get(id);
    }


    // **** Data update one Shortlist by Id ****
    @PutMapping("api/shortlist/{id}")
    String updateShortlist(@RequestBody String body, @PathVariable("id") Long id){
        String shortlist = body;
        return shortlist;
    }


    // **** Data post one Shortlist by Id ****
    @PostMapping("api/shortlist")
    ShortlistDTO addUserShortlist(@RequestBody ShortlistDTO body){
    	return shortlistService.addShortlist(body);
    }


    // **** Data delete one Shortlist by Id ****
    @DeleteMapping("api/shortlist/{id}")
    String deleteShortlist(@PathVariable("id") Long id){
        return "delete";
    }


    // **** Data delete One Matchsheet by Id ****
    @DeleteMapping("api/gamesheet/{id}")
    String deleteGameSheet(@PathVariable("id") Long id){
        return "delete";
    }


    // **** Data get List of Events by Id ****
    @GetMapping("api/events")
    @ResponseBody
    List<EventDTO> getAllEvents(){
    	return eventsService.getAll();
    }


    // **** Data get One Event by Id ****
    @GetMapping("api/event/{id}")
    EventDTO getEvent(@PathVariable("id") Long id){
    	return eventsService.get(id);
    }


    // **** Data update One Event by Id ****
    @PutMapping("api/event/{id}")
    String updateEvents(@RequestBody String body, @PathVariable("id") Long id){
        String events = body;
        return events;
    }

    // **** Data post One Event by Id ****
    @PostMapping("api/event")
    EventDTO addEvent(@RequestBody EventDTO body){ return eventsService.addEvent(body);}


    // **** Data delete One Event by Id ****
    @DeleteMapping("api/event/{id}")
    String deleteEvents(@PathVariable("id") Long id){
        return "delete";
    }


}
