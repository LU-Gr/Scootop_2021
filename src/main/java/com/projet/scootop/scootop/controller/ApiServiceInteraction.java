package com.projet.scootop.scootop.controller;

import com.projet.scootop.scootop.model.services.interaction.AlertDTO;
import com.projet.scootop.scootop.model.services.interaction.FollowDTO;
import com.projet.scootop.scootop.model.services.interaction.InviteDTO;
import com.projet.scootop.scootop.service.domainuser.ChairmanService;
import com.projet.scootop.scootop.service.domainuser.PlayerService;
import com.projet.scootop.scootop.service.services.interaction.AlertService;
import com.projet.scootop.scootop.service.services.interaction.FollowService;
import com.projet.scootop.scootop.service.services.interaction.InviteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiServiceInteraction {
    private AlertService alertService;
    private FollowService followService;
    private InviteService inviteService;

    public ApiServiceInteraction(AlertService alertService, FollowService followService,InviteService inviteService) {
        this.alertService = alertService;
        this.followService = followService;
        this.inviteService = inviteService;
    }


    @GetMapping("api/alert/{id}")
    AlertDTO getAlert(@PathVariable int id){
        return alertService.get(id);
    }
    @PostMapping("api/alert")
    AlertDTO addAlert(@RequestBody AlertDTO body){
        return alertService.add(body);
    }
    @PutMapping("api/alert/{id}")
    String updateAlert(@RequestBody String body,@PathVariable int id){
        return body;
    }
    @DeleteMapping("api/alert/{id}")
    String deleteAlert(@PathVariable int id){
        return alertService.delete(id);
    }
    @GetMapping("api/alerts")
    List<AlertDTO> getAllAlerts(){
        return alertService.getAll();
    }

    @GetMapping("api/follow/{id}")
    FollowDTO getFollow(@PathVariable int id){
        return followService.get(id);
    }
    @PostMapping("api/follow")
    FollowDTO addFollow(@RequestBody FollowDTO body){
        return followService.add(body);
    }
    @PutMapping("api/follow/{id}")
    String updateFollow(@RequestBody String body,@PathVariable int id){
        return body;
    }
    @DeleteMapping("api/follow/{id}")
    String deleteFollow(@PathVariable int id){
        return followService.delete(id);
    }
    @GetMapping("api/follows")
    List<FollowDTO> getAllFollows(){
        return followService.getAll();
    }

    @GetMapping("api/invite/{id}")
    InviteDTO getInvite(@PathVariable int id){
        return inviteService.get(id);
    }
    @PostMapping("api/invite")
    InviteDTO addInvite(@RequestBody InviteDTO body){
        return inviteService.add(body);
    }
    @PutMapping("api/invite/{id}")
    String updateInvite(@RequestBody String body,@PathVariable int id){
        return body;
    }
    @DeleteMapping("api/invite/{id}")
    String deleteInvite(@PathVariable int id){
        return inviteService.delete(id);
    }
    @GetMapping("api/invites")
    List<InviteDTO> getAllInvites(){
        return inviteService.getAll();
    }

}
