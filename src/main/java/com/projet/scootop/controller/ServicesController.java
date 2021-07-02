package com.projet.scootop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.scootop.model.services.EventDTO;
import com.projet.scootop.model.services.LocationWearableDTO;
import com.projet.scootop.model.services.ShortlistDTO;
import com.projet.scootop.model.services.WearableCompanyDTO;
import com.projet.scootop.model.services.WearableDTO;
import com.projet.scootop.service.services.EventService;
import com.projet.scootop.service.services.LocationWearableService;
import com.projet.scootop.service.services.ShortlistService;
import com.projet.scootop.service.services.WearableCompanyService;
import com.projet.scootop.service.services.WearableService;

@RequestMapping("/services")
@RestController
public class ServicesController {

    @Autowired private ShortlistService shortlistService;
    @Autowired private LocationWearableService locationWearableService;
    @Autowired private EventService eventService;
    @Autowired private WearableService wearableService;
    @Autowired private WearableCompanyService wearableCompanyService;
    
    //GET ALL
    @GetMapping("/events")
    @ResponseBody
    List<EventDTO> getEvents(){
    	return eventService.getAll();
    }
    
    @GetMapping("/shortlists")
    @ResponseBody
    List<ShortlistDTO> getShortlists(){
    	return shortlistService.getAll();
    }
    
    @GetMapping("/match/wearables")
    @ResponseBody
    List<LocationWearableDTO> getRentedWearables(){
    	return locationWearableService.getAll();
    }
    
    // **** MatchSheet Data return wearables by team ****
    @GetMapping("/match/{matchId}/team/{TeamId}/wearables")
    @ResponseBody
    List<LocationWearableDTO> getAllByWearablesByMatchSheetId(@PathVariable("matchId") Long matchId, @PathVariable("TeamId") Long teamId ){
    	return locationWearableService.getAllByMatchSheetAndTeam(matchId,teamId);
    }
    
    @GetMapping("/wearables")
    @ResponseBody
    List<WearableDTO> getWearables(){
    	return wearableService.getAll();
    }
    
    @GetMapping("/wearable/companies")
    @ResponseBody
    List<WearableCompanyDTO> getWearableCompanies(){
    	return wearableCompanyService.getAll();
    }
    
    
    
    //GET ONE
    @GetMapping("/event/{id}")
    EventDTO getEvent(@PathVariable("id") Long id){
    	return eventService.get(id);
    }
    
    @GetMapping("/match/wearable/{id}")
    LocationWearableDTO getRentedWearable(@PathVariable("id") Long id){
    	return locationWearableService.get(id);
    }
    
    // **** MatchSheet Data return One wearable in matchSheet Team wearables list by Team ****
    @GetMapping("/match/{matchId}/team/{TeamId}/wearables/{playerId}")
    LocationWearableDTO getOneByMatchSheetAndTeamAndPlayer(@PathVariable("matchId") Long matchsheetId,@PathVariable("TeamId") Long teamId,@PathVariable("playerId") Long playerId ){
        return locationWearableService.getOneByMatchSheetAndTeamAndPlayer(matchsheetId, teamId, playerId);
    }


    // **** MatchSheet Data return One wearable in game wearable list by id ****
    @GetMapping("/matchsheet/{matchId}/wearables/{wearableId}")
    LocationWearableDTO getGameWearable(@PathVariable("matchId") Long matchsheetId,@PathVariable("wearableId") Long id ){
        return locationWearableService.get(matchsheetId);
    }
    
    @GetMapping("/shortlist/{id}")
    ShortlistDTO getUserShortlist(@PathVariable("id") Long id){
    	return shortlistService.get(id);
    }
    
    @GetMapping("/wearable/company/{id}")
    WearableCompanyDTO getWearableCompany(@PathVariable("id") Long id){
    	return wearableCompanyService.get(id);
    }
    
    @GetMapping("/wearable/{id}")
    WearableDTO getWearable(@PathVariable("id") Long id){
    	return wearableService.get(id);
    }
    
    
    
    //CREATE
    @PostMapping("/event")
    EventDTO addEvent(@RequestBody EventDTO body){ 
    	return eventService.addEvent(body);
    }
    
    @PostMapping("/match/wearable")
    LocationWearableDTO addLocationWearable(@RequestBody LocationWearableDTO body){
        return locationWearableService.add(body);
    }
    
    @PostMapping("/shortlist")
    ShortlistDTO addUserShortlist(@RequestBody ShortlistDTO body){
    	return shortlistService.addShortlist(body);
    }
       
    
    @PostMapping("/wearable/company")
    WearableCompanyDTO addWearableCompany(@RequestBody WearableCompanyDTO body){
    	return wearableCompanyService.add(body);
    }
    
    @PostMapping("/wearable")
    WearableDTO addWearable(@RequestBody WearableDTO body){
    	return wearableService.add(body);
    }
    
    
    //UPDATE
    @PutMapping("/event/{id}")
    EventDTO updateEvent(@RequestBody EventDTO body, @PathVariable Long id){
        return eventService.update(body);
    }
    
    @PutMapping("/match/wearable/{id}")
    LocationWearableDTO updateLocationWearable(@RequestBody LocationWearableDTO wearableDTO, @PathVariable Long id){
        return locationWearableService.update(wearableDTO);
    }

    @PutMapping("/shortlist/{id}")
    ShortlistDTO updateShortlist(@RequestBody ShortlistDTO body, @PathVariable Long id){
        return shortlistService.update(body);
    }
    
    @PutMapping("/wearable/company/{id}")
    WearableCompanyDTO updateWearableCompany(@RequestBody WearableCompanyDTO body, @PathVariable Long id){
        return wearableCompanyService.update(body);
    }
    
    @PutMapping("/wearable/{id}")
    WearableDTO updateWearable(@RequestBody WearableDTO body, @PathVariable Long id){
        return wearableService.update(body);
    }
    
    
    
    
    //DELETE
    @DeleteMapping("/event/{id}")
    String deleteEvent(@PathVariable("id") Long id){
    	return eventService.delete(id);
    }
   
    @DeleteMapping("/match/wearable/{id}")
    String deleteRentedWearable(@PathVariable("id") Long id){
        return locationWearableService.delete(id);
    }
    
    @DeleteMapping("/shortlist/{id}")
    String deleteShortlist(@PathVariable("id") Long id){
    	return shortlistService.delete(id);
    }
    
    @DeleteMapping("/wearable/company/{id}")
    String deleteWearableCompany(@PathVariable("id") Long id){
        return wearableCompanyService.delete(id);
    }

    @DeleteMapping("/wearable/{id}")
    String deleteWearable(@PathVariable("id") Long id){
        return wearableService.delete(id);
    }

    
    


    


    


    


}
