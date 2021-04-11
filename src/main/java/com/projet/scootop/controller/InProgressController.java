package com.projet.scootop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.model.inprogress.MatchSheetDTO;
import com.projet.scootop.model.inprogress.StatisticalSheetDTO;
import com.projet.scootop.service.inprogess.MatchSheetService;
import com.projet.scootop.service.inprogess.StatisticalSheetService;

import java.util.List;

@RestController
public class InProgressController {
    private StatisticalSheetService statisticalSheetService;
    private MatchSheetService matchSheetService;

    public InProgressController(StatisticalSheetService statisticalSheetService, MatchSheetService matchSheetService) {
        this.statisticalSheetService = statisticalSheetService;
        this.matchSheetService = matchSheetService;
    }

    @GetMapping("api/matchsheet/{id}")
    MatchSheet getMatchSheet(@PathVariable Long id){
        return matchSheetService.get(id);
    }

    @PostMapping("api/matchsheet")
    MatchSheet addMatchSheet(@RequestBody MatchSheetDTO body) throws Exception {
        return matchSheetService.add(body);
    }
    @PutMapping("api/matchsheet/{id}")
    MatchSheet updateMatchSheet(@RequestBody MatchSheetDTO body,@PathVariable Long id) throws Exception {
        return matchSheetService.update(body,id);
    }
    @DeleteMapping("api/matchsheet/{id}")
    ResponseEntity<Integer> deleteMatchSheet(@PathVariable Long id){
        return matchSheetService.delete(id);
    }
    @GetMapping("api/matchsheets")
    List<MatchSheet> getAllMatchSheets(){
        return matchSheetService.getAll();

    }
    @GetMapping("api/statisticalsheet/{id}")

    StatisticalSheet getStatisticalSheet(@PathVariable Long id){
    return statisticalSheetService.get(id);
    }

    @PostMapping("api/statisticalsheet/{id}")
    StatisticalSheet addStatisticalSheet(@RequestBody StatisticalSheetDTO body, @PathVariable Long id) throws Exception {
        return statisticalSheetService.add(body);
    }
    @PutMapping("api/statisticalsheet/{id}")
    StatisticalSheet updateStatisticalSheet(@RequestBody StatisticalSheetDTO body,@PathVariable Long id) throws Exception {
        return statisticalSheetService.update(body,id);
    }
    @DeleteMapping("api/statisticalsheet/{id}")
    ResponseEntity<Integer> deleteStatisticalSheet(@PathVariable Long id){
        return statisticalSheetService.delete(id);
    }
    @GetMapping("api/statisticalsheet")
    List<StatisticalSheet> getStatisticalSheet(){
        return statisticalSheetService.getAll();

    }
}
