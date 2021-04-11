package com.projet.scootop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.domain.domainuser.Chairman;
import com.projet.scootop.domain.domainuser.Coach;
import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.model.domainuser.ChairmanDTO;
import com.projet.scootop.model.domainuser.CoachDTO;
import com.projet.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.model.domainuser.ScootDTO;
import com.projet.scootop.service.domainuser.ChairmanService;
import com.projet.scootop.service.domainuser.CoachService;
import com.projet.scootop.service.domainuser.PlayerService;
import com.projet.scootop.service.domainuser.ScootService;

import java.util.List;

@RestController
public class DomainUserController {
	
	@Autowired
    private PlayerService playerService;
    private ChairmanService chairmanService;
    private ScootService scootService;
    private CoachService coachService;

    public DomainUserController(PlayerService playerService,ChairmanService chairmanService,ScootService scootService,CoachService coachService) {
        super();
        this.playerService = playerService;
        this.chairmanService = chairmanService;
        this.scootService = scootService;
        this.coachService = coachService;
    }

    @GetMapping("api/chairmen")
    List<ChairmanDTO> getAllStaffChairmen(){
        return chairmanService.getAll();
    }
    @GetMapping("api/chairman/{id}")
    ChairmanDTO getStaffChairman(@PathVariable("id") Long id) throws Exception{
        return chairmanService.get(id);
    }
    @PutMapping("api/chairman/{id}")
    ChairmanDTO updateStaffChairman(@RequestBody ChairmanDTO body) throws Exception {
        return chairmanService.update(body);
    }
    @PostMapping("api/chairman")
    ChairmanDTO addStaffChairman(@RequestBody ChairmanDTO body) throws Exception{
        return chairmanService.add(body);
    }
    @DeleteMapping("api/chairman/{id}")
    String deleteStaffChairman(@PathVariable("id") Long id) {
        return chairmanService.delete(id);
    }

    @PostMapping("api/scoot")
    ScootDTO postScoot(@RequestBody ScootDTO body) throws Exception{
        return scootService.add(body);
    }
    @GetMapping("api/scoot/{id}")
    ScootDTO getScoot(@PathVariable Long id){
        return scootService.get(id);
    }
    @PutMapping("api/scoot/{id}")
    ScootDTO updateScoot(@RequestBody ScootDTO body,@PathVariable Long id) throws Exception {
        return scootService.update(body,id);
    }
    @GetMapping("api/scoots")
    List<ScootDTO> getAllScoots(){
        return scootService.getAll();
    }
    @DeleteMapping("api/scoots/{id}")
    String deleteScoot(@PathVariable("id") Long id) {
        return scootService.delete(id);
    }


    @GetMapping("api/players")
    List<PlayerDTO> getAllPlayers(){
        return playerService.getAll();
    }
    @GetMapping("api/players/{id}")
    PlayerDTO getPlayer(@PathVariable Long id){
        return playerService.get(id);
    }
    @PostMapping("api/player")
    PlayerDTO addPlayer(@RequestBody PlayerDTO body){
        return playerService.add(body);
    }

    @PutMapping("api/players/{id}")
    PlayerDTO updatePlayer(@RequestBody PlayerDTO body){
        return playerService.update(body);

    }
    @DeleteMapping("api/players/{id}")
    String deletePlayer(@PathVariable Long id){
        return playerService.delete(id);
    }
    @GetMapping("api/coaches")
    List<CoachDTO> getAllCoaches(){
        return coachService.getAll();
    }
    @PostMapping("api/coach")
    CoachDTO addCoach(@RequestBody CoachDTO body) throws Exception {
        return coachService.add(body);
    }
    @GetMapping("api/coach/{id}")
    CoachDTO getCoach(@PathVariable Long id){
        return coachService.get(id);
    }
    @PutMapping("api/coach/{id}")
    CoachDTO updateCoach(@RequestBody CoachDTO body) throws Exception {
        return coachService.update(body);
    }
    @DeleteMapping("api/coach/{id}")
    String deleteCoach(@PathVariable Long id){
        return coachService.delete(id);
    }




}
