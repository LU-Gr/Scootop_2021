package com.projet.scootop.scootop.controller;

import com.projet.scootop.scootop.model.statistical.PassDTO;
import com.projet.scootop.scootop.domain.statistical.Goal;
import com.projet.scootop.scootop.domain.statistical.Pass;
import com.projet.scootop.scootop.domain.statistical.Shoot;
import com.projet.scootop.scootop.domain.statistical.physical.TypeTouch;
import com.projet.scootop.scootop.model.statistical.GoalDTO;
import com.projet.scootop.scootop.model.statistical.ShootDTO;
import com.projet.scootop.scootop.model.statistical.TypeTouchDTO;
import com.projet.scootop.scootop.service.stastistical.PassService;
import com.projet.scootop.scootop.service.stastistical.GoalService;
import com.projet.scootop.scootop.service.stastistical.ShootService;
import com.projet.scootop.scootop.service.stastistical.physical.TypeTouchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiStatisticalController {
    private GoalService goalService;
    private ShootService shootService;
    private TypeTouchService typeTouchService;
    private PassService assistService;

    public ApiStatisticalController(GoalService goalService, ShootService shootService, TypeTouchService typeTouchService, PassService assistService) {

        this.goalService = goalService;
        this.shootService = shootService;
        this.typeTouchService = typeTouchService;
        this.assistService = assistService;
    }

    @GetMapping("api/goal/{id}")
    Goal getGoal(@PathVariable Long id){
        return goalService.get(id);
    }
    @PostMapping("api/goal")
    Goal addGoal(@RequestBody GoalDTO body){
        return goalService.add(body);
    }
    @PutMapping("api/goal/{id}")
    Goal updateGoal(@RequestBody GoalDTO body,@PathVariable Long id){
        return goalService.add(body);
    }
    @DeleteMapping("api/goal/{id}")
    String deleteGoal(@PathVariable Long id){
        return goalService.delete(id);
    }
    @GetMapping("api/goals")
    List<Goal> getAllGoals(){
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
    Pass getAssist(@PathVariable Long id){
        return assistService.get(id);
    }
    @PostMapping("api/assist")
    Pass addAssist(@RequestBody PassDTO body){
        return assistService.add(body);
    }
    @PutMapping("api/assist/{id}")
    Pass updateAssist(@RequestBody PassDTO body, @PathVariable Long id){
        return assistService.update(body,id);
    }
    @DeleteMapping("api/assist/{id}")
    String deleteAssist(@PathVariable Long id){
        return assistService.delete(id);
    }
    @GetMapping("api/assists")
    List<Pass> getAllAssists(){
        return assistService.getAll();
    }
    @GetMapping("api/shoot/{id}")
    Shoot getShoot(@PathVariable Long id){
        return shootService.get(id);
    }
    @PostMapping("api/shoot")
    Shoot addShoot(@RequestBody ShootDTO body){
        return shootService.add(body);
    }
    @PutMapping("api/shoot/{id}")
    Shoot updateShoot(@RequestBody ShootDTO body,@PathVariable Long id){
        return shootService.update(body,id);
    }
    @DeleteMapping("api/shoot/{id}")
    String deleteShoot(@PathVariable Long id){
        return shootService.delete(id);
    }
    @GetMapping("api/shoots")
    List<Shoot> getAllShoots(){
        return shootService.getAll();
    }
    @GetMapping("api/type_touch/{id}")
    TypeTouch getTypeTouch(@PathVariable Long id){
        return typeTouchService.get(id);
    }
    @PostMapping("api/type_touch")
    TypeTouch addTypeTouch(@RequestBody TypeTouchDTO body){
        return typeTouchService.add(body);
    }
    @PutMapping("api/type_touch/{id}")
    TypeTouch updateTypeTouch(@RequestBody TypeTouchDTO body,@PathVariable Long id){
        return typeTouchService.update(body,id);
    }
    @DeleteMapping("api/type_touch/{id}")
    ResponseEntity<Integer> deleteTypeTouch(@PathVariable Long id){
        return typeTouchService.delete(id);
    }
    @GetMapping("api/type_touch_all")
    List<TypeTouch> getAllTypeTouch(){
        return typeTouchService.getAll();
    }
}
