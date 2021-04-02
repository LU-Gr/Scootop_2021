package com.projet.scootop.scootop.controller;

import com.projet.scootop.scootop.domain.inprogess.MatchSheet;
import com.projet.scootop.scootop.domain.inprogess.StatisticalSheet;
import com.projet.scootop.scootop.model.domainconfiguration.TypeDTO;
import com.projet.scootop.scootop.model.inprogress.MatchSheetDTO;
import com.projet.scootop.scootop.model.inprogress.StatisticalSheetDTO;
import com.projet.scootop.scootop.service.inprogess.MatchSheetService;
import com.projet.scootop.scootop.service.inprogess.StatisticalSheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiInProgressController {
    private StatisticalSheetService statisticalSheetService;
    private MatchSheetService matchSheetService;

    public ApiInProgressController(StatisticalSheetService statisticalSheetService, MatchSheetService matchSheetService) {
        this.statisticalSheetService = statisticalSheetService;
        this.matchSheetService = matchSheetService;
    }

    @GetMapping("api/matchsheet/{id}")
    MatchSheet getMatchSheet(@PathVariable int id){
        return matchSheetService.get(id);
    }

    @PostMapping("api/matchsheet")
    MatchSheet addMatchSheet(@RequestBody MatchSheetDTO body) throws Exception {
        return matchSheetService.add(body);
    }
    @PutMapping("api/matchsheet/{id}")
    MatchSheet updateMatchSheet(@RequestBody MatchSheetDTO body,@PathVariable int id) throws Exception {
        return matchSheetService.update(body,id);
    }
    @DeleteMapping("api/matchsheet/{id}")
    ResponseEntity<Integer> deleteMatchSheet(@PathVariable int id){
        return matchSheetService.delete(id);
    }
    @GetMapping("api/matchsheets")
    List<MatchSheet> getAllMatchSheets(){
        return matchSheetService.getAll();

    }
    @GetMapping("api/statisticalsheet/{id}")

    StatisticalSheet getStatisticalSheet(@PathVariable int id){
    return statisticalSheetService.get(id);
    }

    @PostMapping("api/statisticalsheet/{id}")
    StatisticalSheet addStatisticalSheet(@RequestBody StatisticalSheetDTO body, @PathVariable int id) throws Exception {
        return statisticalSheetService.add(body);
    }
    @PutMapping("api/statisticalsheet/{id}")
    StatisticalSheet updateStatisticalSheet(@RequestBody StatisticalSheetDTO body,@PathVariable int id) throws Exception {
        return statisticalSheetService.update(body,id);
    }
    @DeleteMapping("api/statisticalsheet/{id}")
    ResponseEntity<Integer> deleteStatisticalSheet(@PathVariable int id){
        return statisticalSheetService.delete(id);
    }
    @GetMapping("api/statisticalsheet")
    List<StatisticalSheet> getStatisticalSheet(){
        return statisticalSheetService.getAll();

    }
}
