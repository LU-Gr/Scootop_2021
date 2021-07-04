package com.projet.scootop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.scootop.model.tools.ClubDTO;
import com.projet.scootop.model.tools.CompetitionDTO;
import com.projet.scootop.model.tools.MatchDTO;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.model.tools.StatisticalSheetDTO;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.service.tools.ClubService;
import com.projet.scootop.service.tools.CompetitionService;
import com.projet.scootop.service.tools.MatchService;
import com.projet.scootop.service.tools.SaisonService;
import com.projet.scootop.service.tools.StatisticalSheetService;
import com.projet.scootop.service.tools.TeamService;


@RestController
@RequestMapping("/tools")
public class ToolsController {
	

	@Autowired private ClubService clubService;
	@Autowired private CompetitionService competitionService;
    @Autowired private MatchService matchSheetService;
    @Autowired private SaisonService saisonService;
    @Autowired private StatisticalSheetService statisticalSheetService;
	@Autowired private TeamService teamService;
	
	
	//GET ONE
	@GetMapping("/club/{id}")
    ClubDTO getClub(@PathVariable Long id){
        return clubService.get(id);
    }
	
	@GetMapping("/competition/{id}")
	CompetitionDTO getCompetition(@PathVariable Long id) {
		return competitionService.get(id);
	}
	
	@GetMapping("/match/{id}")
    MatchDTO getMatchSheet(@PathVariable Long id){
        return matchSheetService.get(id);
    }
	
	@GetMapping("/saison/{id}")
    SaisonDTO getSaison(@PathVariable Long id){
        return saisonService.get(id);
    }
    
    @GetMapping("/stats/{id}")
    StatisticalSheetDTO getStatisticalSheet(@PathVariable Long id){
	    return statisticalSheetService.get(id);
    }
    
    @GetMapping("/stats/{playerId}/{eventId}")
    StatisticalSheetDTO getStatisticalSheetByPlayerAndEvent(@PathVariable Long playerId, @PathVariable Long eventId) {
    	return statisticalSheetService.getSheetByPlayerAndEvent(playerId, eventId);
    }
	
    @GetMapping("/team/{id}")
    TeamDTO getTeam(@PathVariable Long id){
        return teamService.get(id);
    }
	
    
    
    
	//GET ALL
	@GetMapping("/clubs")
    List<ClubDTO> getAllClubs(){ 
    	return clubService.getAll();
    }
	
	@GetMapping("/clubs/{country}")
    List<ClubDTO> getClubsByCountry(@PathVariable String country){ 
    	return clubService.findAllByCountry(country);
    }
	
	@GetMapping("/competitions")
    List<CompetitionDTO> getAllCompetitions(){ 
    	return competitionService.getAll();
    }
	
	@GetMapping("/matchs")
    List<MatchDTO> getAllMatchSheets(){
        return matchSheetService.getAll();
    }
	
	@GetMapping("/saisons")
    List<SaisonDTO> getAllSaison(){
        return saisonService.getAll();
    }
    
    @GetMapping("/statisticalsheets")
    List<StatisticalSheetDTO> getStatisticalSheet(){
        return statisticalSheetService.getAll();
    }
	
    @GetMapping("/teams")
    List<TeamDTO> getAllTeams(){
        return teamService.getAll();
    }
    
    @GetMapping("/teams/{club_id}")
    List<TeamDTO> getTeamsByClub(){
        return teamService.getAll();
    }
    
    
    
    
    
	//CREATE
	@PostMapping("/club")
    ClubDTO addClub(@RequestBody ClubDTO club) {
        return clubService.add(club);
    }
	
	@PostMapping("/competition")
    CompetitionDTO addCompetition(@RequestBody CompetitionDTO body){
        return competitionService.add(body);
    }
	
	@PostMapping("/match")
    MatchDTO addMatchSheet(@RequestBody MatchDTO body) throws Exception {
        return matchSheetService.add(body);
    }
	
	@PostMapping("/saison")
    SaisonDTO addSaison(@RequestBody SaisonDTO body){
        return saisonService.add(body);
    }
    
    @PostMapping("/statisticalsheet")
    StatisticalSheetDTO addStatisticalSheet(@RequestBody StatisticalSheetDTO body){
        return statisticalSheetService.add(body);
    }
	
    @PostMapping("/team")
    TeamDTO addTeam(@RequestBody TeamDTO body){
        return teamService.add(body);
    }
    
    
    
    
    
    
	
	//UPDATE
	@PutMapping("/club/{id}")
    ClubDTO updateClub(@RequestBody ClubDTO body, @PathVariable Long id) {
        return clubService.update(body);
    }
	
	@PutMapping("/competition/{id}")
	CompetitionDTO updateTeam(@RequestBody CompetitionDTO body, @PathVariable Long id) {
        return competitionService.update(body);
    }
	
	@PutMapping("/match/{id}")
    MatchDTO updateMatchSheet(@RequestBody MatchDTO body, @PathVariable Long id){
        return matchSheetService.update(body);
    }
	
	@PutMapping("/saison/{id}")
    String updateSaison(@RequestBody String body,@PathVariable Long id){
        return body;
    }
    
    @PutMapping("/statisticalsheet/{id}")
    StatisticalSheetDTO updateStatisticalSheet(@RequestBody StatisticalSheetDTO body, @PathVariable Long id){
        return statisticalSheetService.update(body);
    }
	
    @PutMapping("/team/{id}")
	TeamDTO updateTeam(@RequestBody TeamDTO body, @PathVariable Long id) {
        return teamService.update(body);
    }
    
    
    
    
    
    
    
    
	//DELETE
	@DeleteMapping("/club/{id}")
    String deleteClub(@PathVariable Long id){
        return clubService.delete(id);
    }

	@DeleteMapping("/competition/{id}")
    String deleteCompetition(@PathVariable Long id){
        return competitionService.delete(id);
    }

	@DeleteMapping("/match/{id}")
	ResponseEntity<Integer> deleteMatchSheet(@PathVariable Long id){
	    return matchSheetService.delete(id);
	}
    
	@DeleteMapping("/saison/{id}")
    String deleteSaison(@PathVariable Long id){
        return saisonService.delete(id);
    }
    
    @DeleteMapping("/statisticalsheet/{id}")
    ResponseEntity<Integer> deleteStatisticalSheet(@PathVariable Long id){
        return statisticalSheetService.delete(id);
    }
    
    @DeleteMapping("/team/{id}")
    String deleteTeam(@PathVariable Long id){
        return teamService.delete(id);
    }
}
