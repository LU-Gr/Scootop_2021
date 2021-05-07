package com.projet.scootop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.service.tools.MatchService;
import com.projet.scootop.service.tools.StatisticalSheetService;

import java.util.List;

@RestController
public class InProgressController {
	
    @Autowired private StatisticalSheetService statisticalSheetService;
    @Autowired private MatchService matchSheetService;

    @GetMapping("api/matchsheet/{id}")
    MatchDTO getMatchSheet(@PathVariable Long id){
        return matchSheetService.get(id);
    }

    @PostMapping("api/matchsheet")
    MatchDTO addMatchSheet(@RequestBody MatchDTO body) throws Exception {
        return matchSheetService.add(body);
    }
    
    @PutMapping("api/matchsheet/{id}")
    MatchDTO updateMatchSheet(@RequestBody MatchDTO body) throws Exception {
        return matchSheetService.update(body);
    }
    
    @DeleteMapping("api/matchsheet/{id}")
    ResponseEntity<Integer> deleteMatchSheet(@PathVariable Long id){
        return matchSheetService.delete(id);
    }
    
    @GetMapping("api/matchsheets")
    List<MatchDTO> getAllMatchSheets(){
        return matchSheetService.getAll();
    }
    
    @GetMapping("api/statisticalsheet/{id}")
    StatisticalSheetDTO getStatisticalSheet(@PathVariable Long id){
	    return statisticalSheetService.get(id);
    }

    @PostMapping("api/statisticalsheet/{id}")
    StatisticalSheetDTO addStatisticalSheet(@RequestBody StatisticalSheetDTO body, @PathVariable Long id) throws Exception {
        return statisticalSheetService.add(body);
    }
    
    @PutMapping("api/statisticalsheet/{id}")
    StatisticalSheetDTO updateStatisticalSheet(@RequestBody StatisticalSheetDTO body) throws Exception {
        return statisticalSheetService.update(body);
    }
    
    @DeleteMapping("api/statisticalsheet/{id}")
    ResponseEntity<Integer> deleteStatisticalSheet(@PathVariable Long id){
        return statisticalSheetService.delete(id);
    }
    
    @GetMapping("api/statisticalsheet")
    List<StatisticalSheetDTO> getStatisticalSheet(){
        return statisticalSheetService.getAll();
    }
}
