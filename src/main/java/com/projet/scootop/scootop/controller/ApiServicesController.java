package com.projet.scootop.scootop.controller;

import com.projet.scootop.scootop.ApiApplication;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.model.domainuser.PlayerDTO;
import com.projet.scootop.scootop.model.domainuser.ScootDTO;
import com.projet.scootop.scootop.model.inprogress.StatisticalSheetDTO;
import com.projet.scootop.scootop.model.services.*;
import com.projet.scootop.scootop.repository.services.GameSheetRepository;
import com.projet.scootop.scootop.repository.services.WearableRepository;
import com.projet.scootop.scootop.service.domainuser.PlayerService;
import com.projet.scootop.scootop.service.domainuser.ScootService;
import com.projet.scootop.scootop.service.inprogess.MatchSheetService;
import com.projet.scootop.scootop.service.inprogess.StatisticalSheetService;
import com.projet.scootop.scootop.service.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ApiServicesController {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    private UserResumeService userResumeService;
    private ShortlistService  shortlistService;
    private GameSheetService  gameSheetService;
    private EventsService     eventsService;
    private WearableService   wearableService;
    private StatisticalSheetService statisticalSheetService;
    private PlayerService playerService;
    private ScootService scootService;
    private MatchSheetService matchSheetService;
    private WearableRepository wearableRepository;
    private GameSheetRepository gameSheetRepository;


    public ApiServicesController(UserResumeService serResumeService, ShortlistService shortlistService, GameSheetService gameSheetService, EventsService eventsService, WearableService wearableService, StatisticalSheetService statisticalSheetService,PlayerService playerService, MatchSheetService matchSheetService ) {
        super();
        this.userResumeService = serResumeService;
        this.shortlistService = shortlistService;
        this.gameSheetService = gameSheetService;
        this.eventsService = eventsService;
        this.wearableService = wearableService;
        this.statisticalSheetService = statisticalSheetService;
        this.playerService = playerService;
        this.matchSheetService = matchSheetService;

    }

    // **** MatchSheet Data ****


    // **** MatchSheet Data return wearables by team ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/{TeamId}/wearables")
    @ResponseBody
    List<WearableDTO> getAllByWearablesByMatchSheetId(@PathVariable("matchsheetsId") Long matchId, @PathVariable("TeamId") Long teamId ){
    return wearableService.getAllByMatchSheetAndTeam(matchId,teamId);}


    // **** MatchSheet Data return player by team ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/{TeamId}/players")
    @ResponseBody
    List<PlayerDTO> getAllPlayerByMatchSheetAndTeam(@PathVariable("matchsheetsId") Long matchId, @PathVariable("TeamId") List<Team> teams ){
        return playerService.getAllPlayerByMatchSheetAndTeams(matchId,teams);}

    // **** MatchSheet Data return StatisticalSheet ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/stats")
    StatisticalSheetDTO getStatSheetByMatchSheet(@PathVariable("matchsheetsId") Long matchsheetId){
        return statisticalSheetService.getOneStatSheetByMatchSheet(matchsheetId);
    }

    // **** MatchSheet Data return One wearable in matchSheet Team wearables list by Team ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/{TeamId}/wearables/{playeurId}")
    WearableDTO getOneByMatchSheetAndTeamAndPlayer(@PathVariable("matchsheetsId") Long matchsheetId,@PathVariable("TeamId") Long teamId,@PathVariable("playeurId") Long playersId ){
        return wearableService.getOneByMatchSheetAndTeamAndPlayer(matchsheetId,teamId,playersId);
    }


    // **** MatchSheet Data return One wearable in game wearable list by id ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/wearables/{wearableId}")
    WearableDTO getGameWearable(@PathVariable("matchsheetsId") Long matchsheetId,@PathVariable("wearableId") Long id ){
        return wearableService.get(matchsheetId);
    }


    // **** MatchSheet Data return List of Avalaible Scoot ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/scoots")
    @ResponseBody
    List<ScootDTO> getAllByScootByMatchSheetId(@PathVariable("matchsheetsId") Long matchId){
        return scootService.getAllByMatcSheetId(matchId);}

    // **** MatchSheet Data return One Scoot ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/scoot/{id}")
    ScootDTO getScoot(@PathVariable("id") Long id){return scootService.get(id);}

    // **** MatchSheet Data return All Wearables ****
    @GetMapping("/api/matchsheet/{matchsheetsId}/wearables")
    @ResponseBody
    List<WearableDTO> getAllByWearablesByMatchSheetId(@PathVariable("matchsheetsId") Long matchId){
    return wearableService.getAllByMatcSheetId(matchId);}

    // **** Data return All Wearables ****
    @GetMapping("api/wearables")
    @ResponseBody
    List<WearableDTO> getAllWearable(){return wearableService.getAll();}

    // **** Data return One Wearable By Id Wearables ****
    @GetMapping("api/wearable/{id}")
    WearableDTO getWearable(@PathVariable("id") Long id){return wearableService.get(id);}


    // **** Data update One Wearable By Id Wearables ****
    @PutMapping("api/wearable/{id}")
    String updateWearable(@RequestBody String body, @PathVariable("id") Long id){
        String wearable = body;
        return wearable;
    }


    // **** Data post One Wearable By Id Wearables ****
    @PostMapping("api/wearable")
    WearableDTO addWearable(@RequestBody WearableDTO body){
        WearableDTO wearable = body;
        return wearable;
    }


    // **** Data delete One Wearable By Id Wearables ****
    @DeleteMapping("api/wearable/{id}")
    String deleteWearable(@PathVariable("id") Long id){

        return "delete";
    }


    // **** Data get list of Player Resumes ****
    @GetMapping("api/userresumes")
    @ResponseBody
    List<UserResumeDTO> getAllUserResume(){ return userResumeService.getAll();}


    // **** Data get one Player Resume by Id ****
    @GetMapping("api/userresume/{id}")
    UserResumeDTO getUserResume(@PathVariable("id") Long id){ return userResumeService.get(id); }


    // **** Data update one Player Resume by Id ****
    @PutMapping("api/userresume/{id}")
    String updateUserResume(@RequestBody String body, @PathVariable("id") Long id){
        String userresume = body;
        return userresume;
    }

    // **** Data post one Player Resume ****
    @PostMapping("api/userresume")
    UserResumeDTO addUserResume(@RequestBody UserResumeDTO body){
        return userResumeService.addUserResume(body);
    }
    @DeleteMapping("api/userresume/{id}")
    String deleteUserResume(@PathVariable("id") Long id){

        return "delete";
    }



    // **** Data list  of Shortlist ****
    @GetMapping("api/shortlists")
    @ResponseBody
    List<ShortlistDTO> getAllShortlist(){return shortlistService.getAll();}


    // **** Data get one Shortlist by Id ****
    @GetMapping("api/shortlist/{id}")
    ShortlistDTO getUserShortlist(@PathVariable("id") Long id){return shortlistService.get(id);}


    // **** Data update one Shortlist by Id ****
    @PutMapping("api/shortlist/{id}")
    String updateShortlist(@RequestBody String body, @PathVariable("id") Long id){
        String shortlist = body;
        return shortlist;
    }


    // **** Data post one Shortlist by Id ****
    @PostMapping("api/shortlist")
    ShortlistDTO addUserShortlist(@RequestBody ShortlistDTO body){ return shortlistService.addShortlist(body);}


    // **** Data delete one Shortlist by Id ****
    @DeleteMapping("api/shortlist/{id}")
    String deleteShortlist(@PathVariable("id") Long id){

        return "delete";
    }


    // **** Data get List Of Matchsheet ****
    @GetMapping("api/gamesheets")
    @ResponseBody
    List<GameSheetDTO> getAllGameSheet(){return gameSheetService.getAll();}


    // **** Data get One Matchsheet by Id ****
    @GetMapping("api/gamesheet/{id}")
    GameSheetDTO getGameSheet(@PathVariable("id") Long id){return gameSheetService.get(id);}


    // **** Data update One Matchsheet by Id ****
    @PutMapping("api/gamesheet/{id}")
    String updateGameSheet(@RequestBody String body, @PathVariable("id") Long id){
        String gamesheet = body;
        return gamesheet;
    }

    // **** Data post One Matchsheet by Id ****
    @PostMapping("api/gamesheet")
    GameSheetDTO addGameSheet(@RequestBody GameSheetDTO body){ return gameSheetService.addGameSheet(body);}


    // **** Data delete One Matchsheet by Id ****
    @DeleteMapping("api/gamesheet/{id}")
    String deleteGameSheet(@PathVariable("id") Long id){

        return "delete";
    }


    // **** Data get List of Events by Id ****
    @GetMapping("api/events")
    @ResponseBody
    List<EventsDTO> getAllEvents(){return eventsService.getAll();}


    // **** Data get One Event by Id ****
    @GetMapping("api/event/{id}")
    EventsDTO getEvent(@PathVariable("id") Long id){return eventsService.get(id);}


    // **** Data update One Event by Id ****
    @PutMapping("api/event/{id}")
    String updateEvents(@RequestBody String body, @PathVariable("id") Long id){
        String events = body;
        return events;
    }

    // **** Data post One Event by Id ****
    @PostMapping("api/event")
    EventsDTO addEvent(@RequestBody EventsDTO body){ return eventsService.addEvent(body);}


    // **** Data delete One Event by Id ****
    @DeleteMapping("api/event/{id}")
    String deleteEvents(@PathVariable("id") Long id){

        return "delete";
    }


}
