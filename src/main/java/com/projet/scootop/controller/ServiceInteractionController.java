package com.projet.scootop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.model.APIResultDTO;
import com.projet.scootop.model.services.interaction.AlertDTO;
import com.projet.scootop.model.services.interaction.FollowDTO;
import com.projet.scootop.model.services.interaction.InviteDTO;
import com.projet.scootop.service.services.interaction.AlertService;
import com.projet.scootop.service.services.interaction.FollowService;
import com.projet.scootop.service.services.interaction.InviteService;

import java.util.List;

@RequestMapping("/services/interaction")
@RestController
public class ServiceInteractionController {
	
    @Autowired private AlertService alertService;
    @Autowired private FollowService followService;
    @Autowired private InviteService inviteService;

    //GET ALL
    @GetMapping("/alerts")
    List<AlertDTO> getAllAlerts(){
        return alertService.getAll();
    }

    @GetMapping("/follows")
    List<FollowDTO> getAllFollows(){
        return followService.getAll();
    }
   
    @GetMapping("/invites")
    List<InviteDTO> getAllInvites(){
        return inviteService.getAll();
    }
    
    @GetMapping("/invites/{id}")
    List<InviteDTO> getAllInvitesByUser(@PathVariable Long id){
        return inviteService.getAllByUserId(id);
    }
    
    
    
    
    //GET ONE
    @GetMapping("/alert/{id}")
    AlertDTO getAlert(@PathVariable Long id){
        return alertService.get(id);
    }
    
    @GetMapping("/follow/{id}")
    FollowDTO getFollow(@PathVariable Long id){
        return followService.get(id);
    }
    
    @GetMapping("/invite/{id}")
    InviteDTO getInvite(@PathVariable Long id){
        return inviteService.get(id);
    }
    
    
    
    
    //CREATE
    @PostMapping("/alert")
    APIResultDTO addAlert(@RequestBody AlertDTO body){
        return alertService.add(body);
    }
    
    @PostMapping("/follow")
    APIResultDTO addFollow(@RequestBody FollowDTO body){
        return followService.add(body);
    }
    
    @PostMapping("/invite")
    APIResultDTO addInvite(@RequestBody InviteDTO body){
        return inviteService.add(body);
    }
    
    
    //DELETE
    @DeleteMapping("/alert/{id}")
    String deleteAlert(@PathVariable Long id){
        return alertService.delete(id);
    }
    
    @DeleteMapping("/follow/{id}")
    String deleteFollow(@PathVariable Long id){
        return followService.delete(id);
    }
    
    @DeleteMapping("/invite/{id}")
    String deleteInvite(@PathVariable Long id){
        return inviteService.delete(id);
    }

}
