package com.projet.scootop.scootop.controller;


import com.projet.scootop.scootop.domain.domainuser.Chairman;
import com.projet.scootop.scootop.domain.domainuser.Coach;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.model.domainuser.ChairmanDTO;
import com.projet.scootop.scootop.model.domainuser.CoachDTO;
import com.projet.scootop.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.scootop.model.domainuser.ScootDTO;
import com.projet.scootop.scootop.service.domainuser.ChairmanService;
import com.projet.scootop.scootop.service.domainuser.CoachService;
import com.projet.scootop.scootop.service.domainuser.PlayerService;
import com.projet.scootop.scootop.service.domainuser.ScootService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DomainUserController {
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
    List<Chairman> getAllStaffChairmen(){
        return chairmanService.getAll();
    }
    @GetMapping("api/chairman/{id}")
    Chairman getStaffChairman(@PathVariable("id") Long id) throws Exception{
        return chairmanService.get(id);
    }
    @PutMapping("api/chairman/{id}")
    Chairman updateStaffChairman(@RequestBody ChairmanDTO body,@PathVariable("id") Long id) throws Exception {
        return chairmanService.update(body,id);
    }
    @PostMapping("api/chairman")
    Chairman addStaffChairman(@RequestBody ChairmanDTO body) throws Exception{
        return chairmanService.add(body);
    }
    @DeleteMapping("api/chairman/{id}")
    String deleteStaffChairman(@PathVariable("id") Long id) {
        return chairmanService.delete(id);
    }

    @PostMapping("api/scoot")
    Scoot postScoot(@RequestBody ScootDTO body) throws Exception{
        return scootService.add(body);
    }
    @GetMapping("api/scoot/{id}")
    ScootDTO getScoot(@PathVariable Long id){
        return scootService.get(id);
    }
    @PutMapping("api/scoot/{id}")
    Scoot updateScoot(@RequestBody ScootDTO body,@PathVariable Long id) throws Exception {
        return scootService.update(body,id);
    }
    @GetMapping("api/scoots")
    List<Scoot> getAllScoots(){
        return scootService.getAll();
    }
    @DeleteMapping("api/scoots/{id}")
    String deleteScoot(@PathVariable("id") Long id) {
        return scootService.delete(id);
    }


    @GetMapping("api/players")
    List<Player> getAllPlayers(){
        return playerService.getAll();
    }
    @GetMapping("api/players/{id}")
    Player getPlayer(@PathVariable Long id){
        return playerService.get(id);
    }
    @PostMapping("api/player")
    Player addPlayer(@RequestBody PlayerDTO body, Long id){

        return playerService.add(body,id);
    }

    @PutMapping("api/players/{id}")
    Player updatePlayer(@RequestBody PlayerDTO body, @PathVariable Long id){
        return playerService.update(body,id);

    }
    @DeleteMapping("api/players/{id}")
    String deletePlayer(@PathVariable Long id){
        return playerService.delete(id);
    }
    @GetMapping("api/coaches")
    List<Coach> getAllCoaches(){
        return coachService.getAll();
    }
    @PostMapping("api/coach")
    Coach addCoach(@RequestBody CoachDTO body) throws Exception {
        return coachService.add(body);
    }
    @GetMapping("api/coach/{id}")
    Coach getCoach(@PathVariable Long id){
        return coachService.get(id);
    }
    @PutMapping("api/coach/{id}")
    Coach updateCoach(@RequestBody CoachDTO body, @PathVariable Long id) throws Exception {
        return coachService.update(body,id);
    }
    @DeleteMapping("api/coach/{id}")
    String deleteCoach(@PathVariable Long id){
        return coachService.delete(id);
    }




}
