package com.projet.scootop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.model.statistical.GoalDTO;
import com.projet.scootop.model.statistical.PassDTO;
import com.projet.scootop.model.statistical.ShootDTO;
import com.projet.scootop.model.statistical.physical.TypeTouchDTO;
import com.projet.scootop.service.statistical.GoalService;
import com.projet.scootop.service.statistical.PassService;
import com.projet.scootop.service.statistical.ShootService;
import com.projet.scootop.service.statistical.physical.TypeTouchService;

import java.util.List;


@RestController
public class StatisticalController {
    private GoalService goalService;
    private ShootService shootService;
    private TypeTouchService typeTouchService;
    private PassService assistService;

    public StatisticalController(GoalService goalService, ShootService shootService, TypeTouchService typeTouchService, PassService assistService) {

        this.goalService = goalService;
        this.shootService = shootService;
        this.typeTouchService = typeTouchService;
        this.assistService = assistService;
    }

    @GetMapping("api/goal/{id}")
    GoalDTO getGoal(@PathVariable Long id){
        return goalService.get(id);
    }
    @PostMapping("api/goal")
    GoalDTO addGoal(@RequestBody GoalDTO body){
        return goalService.add(body);
    }
    @PutMapping("api/goal/{id}")
    GoalDTO updateGoal(@RequestBody GoalDTO body,@PathVariable Long id){
        return goalService.add(body);
    }
    @DeleteMapping("api/goal/{id}")
    String deleteGoal(@PathVariable Long id){
        return goalService.delete(id);
    }
    @GetMapping("api/goals")
    List<GoalDTO> getAllGoals(){
        return goalService.getAll();

    }
    @GetMapping("api/skill/{id}")
    String getSkill(@PathVariable Long id){
        return "isGoal 1";
    }
    @PostMapping("api/skill")
    String addSkill(@RequestBody String body){
        return body;
    }
    @PutMapping("api/skill/{id}")
    String updateSkill(@RequestBody String body,@PathVariable Long id){
        return body;
    }
    @DeleteMapping("api/skill/{id}")
    String deleteSkill(@PathVariable Long id){
        return "delete";
    }
    @GetMapping("api/skills")
    String getAllSkills(){
        return "[{goooooooal}]";

    }
    @GetMapping("api/assist/{id}")
    PassDTO getAssist(@PathVariable Long id){
        return assistService.get(id);
    }
    @PostMapping("api/assist")
    PassDTO addAssist(@RequestBody PassDTO body){
        return assistService.add(body);
    }
    @PutMapping("api/assist/{id}")
    PassDTO updateAssist(@RequestBody PassDTO body){
        return assistService.update(body);
    }
    @DeleteMapping("api/assist/{id}")
    String deleteAssist(@PathVariable Long id){
        return assistService.delete(id);
    }
    @GetMapping("api/assists")
    List<PassDTO> getAllAssists(){
        return assistService.getAll();
    }
    @GetMapping("api/shoot/{id}")
    ShootDTO getShoot(@PathVariable Long id){
        return shootService.get(id);
    }
    @PostMapping("api/shoot")
    ShootDTO addShoot(@RequestBody ShootDTO body){
        return shootService.add(body);
    }
    @PutMapping("api/shoot/{id}")
    ShootDTO updateShoot(@RequestBody ShootDTO body){
        return shootService.update(body);
    }
    @DeleteMapping("api/shoot/{id}")
    String deleteShoot(@PathVariable Long id){
        return shootService.delete(id);
    }
    @GetMapping("api/shoots")
    List<ShootDTO> getAllShoots(){
        return shootService.getAll();
    }
    @GetMapping("api/type_touch/{id}")
    TypeTouchDTO getTypeTouch(@PathVariable Long id){
        return typeTouchService.get(id);
    }
    @PostMapping("api/type_touch")
    TypeTouchDTO addTypeTouch(@RequestBody TypeTouchDTO body){
        return typeTouchService.add(body);
    }
    @PutMapping("api/type_touch/{id}")
    TypeTouchDTO updateTypeTouch(@RequestBody TypeTouchDTO body){
        return typeTouchService.update(body);
    }
    @DeleteMapping("api/type_touch/{id}")
    ResponseEntity<Integer> deleteTypeTouch(@PathVariable Long id){
        return typeTouchService.delete(id);
    }
    @GetMapping("api/type_touch_all")
    List<TypeTouchDTO> getAllTypeTouch(){
        return typeTouchService.getAll();
    }
}
