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
import org.springframework.web.bind.annotation.RestController;

import com.projet.scootop.model.statistics.ActionDTO;
import com.projet.scootop.model.statistics.GoalDTO;
import com.projet.scootop.model.statistics.PassDTO;
import com.projet.scootop.model.statistics.ShootDTO;
import com.projet.scootop.service.statistics.ActionService;
import com.projet.scootop.service.statistics.GoalService;
import com.projet.scootop.service.statistics.PassService;
import com.projet.scootop.service.statistics.ShootService;

@RequestMapping("/stats")
@RestController
public class StatisticsController {
    
	@Autowired private ActionService actionService;
	@Autowired private GoalService goalService;
	@Autowired private PassService assistService;
	@Autowired private ShootService shootService;


	//GET ONE
	@GetMapping("/goal/{id}")
    GoalDTO getGoal(@PathVariable Long id){
        return goalService.get(id);
    }
	
	@GetMapping("/action/{id}")
    ActionDTO getAction(@PathVariable Long id){
        return actionService.get(id);
    }
	
    @GetMapping("/assist/{id}")
    PassDTO getAssist(@PathVariable Long id){
        return assistService.get(id);
    }
    
    @GetMapping("/shoot/{id}")
    ShootDTO getShoot(@PathVariable Long id){
        return shootService.get(id);
    }
    
    
    
    
    
    
    
    
	//GET ALL
	@GetMapping("/goals")
    List<GoalDTO> getAllGoals(){
        return goalService.getAll();
    }
	
	@GetMapping("/actions")
    List<ActionDTO> getAllActions(){
        return actionService.getAll();
    }
    
    @GetMapping("/assists")
    List<PassDTO> getAllAssists(){
        return assistService.getAll();
    }

    @GetMapping("/shoots")
    List<ShootDTO> getAllShoots(){
        return shootService.getAll();
    }
    
    
    
    
    
	//CREATE
	@PostMapping("/goal")
    GoalDTO addGoal(@RequestBody GoalDTO body){
        return goalService.add(body);
    }
	
	@PostMapping("/action")
    ActionDTO addAction(@RequestBody ActionDTO body){
        return actionService.add(body);
    }
    
    @PostMapping("/assist")
    PassDTO addAssist(@RequestBody PassDTO body){
        return assistService.add(body);
    }
    
    @PostMapping("/shoot")
    ShootDTO addShoot(@RequestBody ShootDTO body){
        return shootService.add(body);
    }
    
    
    
    
    
	//UPDATE
	@PutMapping("/goal/{id}")
    GoalDTO updateGoal(@RequestBody GoalDTO body,@PathVariable Long id){
        return goalService.add(body);
    }
	
	@PutMapping("/action/{id}")
    ActionDTO updateAction(@RequestBody ActionDTO body){
        return actionService.update(body);
    }
    
    @PutMapping("/assist/{id}")
    PassDTO updateAssist(@RequestBody PassDTO body){
        return assistService.update(body);
    }
    
    @PutMapping("/shoot/{id}")
    ShootDTO updateShoot(@RequestBody ShootDTO body){
        return shootService.update(body);
    }
	
    
    
    
    
	
	//DELETE
	@DeleteMapping("/goal/{id}")
    String deleteGoal(@PathVariable Long id){
        return goalService.delete(id);
    }
	
	@DeleteMapping("/action/{id}")
    String deleteAction(@PathVariable Long id){
        return actionService.delete(id);
    }
    
    @DeleteMapping("/assist/{id}")
    String deleteAssist(@PathVariable Long id){
        return assistService.delete(id);
    }
    
    @DeleteMapping("/shoot/{id}")
    String deleteShoot(@PathVariable Long id){
        return shootService.delete(id);
    }

}
