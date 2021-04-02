package com.projet.scootop.scootop.controller;


import com.projet.scootop.scootop.domain.domainconfiguration.*;
import com.projet.scootop.scootop.model.ClubDTO;
import com.projet.scootop.scootop.model.domainconfiguration.*;
import com.projet.scootop.scootop.model.services.WearableDTO;
import com.projet.scootop.scootop.service.domaineconfiguration.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiDomainConfigController {
    private StadeService stadeService;
    private LeagueService leagueService;
    private CategoryService categoryService;
    private ClubService clubService;
    private DivisionsService divisionsService;
    private PosteService posteService;
    private TeamService teamService;
    private TypeService typeService;


    public ApiDomainConfigController(StadeService stadeService, LeagueService leagueService, CategoryService categoryService, ClubService clubService, DivisionsService divisionsService, PosteService posteService, TeamService teamService, TypeService typeService) {
        super();
        this.stadeService = stadeService;
        this.leagueService = leagueService;
        this.categoryService = categoryService;
        this.clubService = clubService;
        this.divisionsService = divisionsService;
        this.posteService = posteService;
        this.teamService = teamService;
        this.typeService = typeService;
    }

    @GetMapping("api/categories")
    List<CategoryDTO> getAllCategory(){
        return categoryService.getAll();
    }


    @GetMapping("api/category/{id}")
    CategoryDTO getCategory(@PathVariable int id){
        return categoryService.get(id);
    }

    @PostMapping("api/category")
    CategoryDTO addCategory(@RequestBody CategoryDTO body){
        CategoryDTO category = body;
        return category;
    }

    @PutMapping("api/category/{id}")
    String updateCategory(@RequestBody String body,@PathVariable int id){
        String category = body;
        return category;
    }

    @DeleteMapping("api/category/{id}")
    String deleteCategory(@PathVariable int id){

        return "Category delete";
    }


    @GetMapping("api/clubs")
    List<ClubDTO> getAllClubs(){ return clubService.getAll();}

    @GetMapping("api/club/{id}")
    ClubDTO getClub(@PathVariable int id){
        return clubService.get(id);
    }

    @PostMapping("api/club")
    ClubDTO addClub(@RequestBody ClubDTO body) {
        ClubDTO club = body;
        return club;
    }

    @PutMapping("api/club/{id}")
    String updateClub(@RequestBody String body,@PathVariable int id) {
        String club = body;
        return club;
    }

    @DeleteMapping("api/club/{id}")
    String deleteClub(@PathVariable int id){
        return clubService.delete(id);
    }


    @GetMapping("api/division/{id}")
    DivisionsDTO getDivision(@PathVariable("id") int id){
        return divisionsService.get(id);
    }
    @PutMapping("api/division/{id}")
    String uploadDivision(@RequestBody String body, @PathVariable("id") int id){
        return body;
    }
    @PostMapping("api/division")
    DivisionsDTO uploadDivision(@RequestBody DivisionsDTO body){
        return divisionsService.add(body,1);
    }
    @DeleteMapping("api/division/{id}")
    String deleteDivision(@PathVariable("id") int id){
        return divisionsService.delete(id);
    }
    @GetMapping("api/divisions")
    List<DivisionsDTO> getAllDivisions(){
        return divisionsService.getAll();
    }

    @GetMapping("api/league/{id}")
    LeagueDTO getLeague(@PathVariable("id") int id){
        return leagueService.get(id);

    }
    @PutMapping("api/league/{id}")
    String uploadLeague(@RequestBody String body, @PathVariable("id") int id){
        return body;
    }
    @PostMapping("api/league")
    LeagueDTO addLeague(@RequestBody LeagueDTO body){

        return leagueService.add(body);
    }
    @DeleteMapping("api/league/{id}")
    String deleteLeague(@PathVariable("id") int id){
        return leagueService.delete(id);
    }
    @GetMapping("api/leagues")
    List<LeagueDTO> getAllLeagues(){
        return leagueService.getAll();
    }

    @GetMapping("api/poste/{id}")
    PosteDTO getPoste(@PathVariable int id){
        return posteService.get(id);
    }

    @PostMapping("api/poste")
    Poste addPoste(@RequestBody PosteDTO body){
        return posteService.addPoste(body);
    }

    @PutMapping("api/poste/{id}")
    Poste updatePoste(@RequestBody PosteDTO body,@PathVariable int id){
        return posteService.update(body,id);
    }

    @DeleteMapping("api/poste/{id}")
    String deletePoste(@PathVariable int id){
        return posteService.delete(id);
    }

    @GetMapping("api/postes")
    List<PosteDTO> getAllPoste(){
        return posteService.getAll();

    }

    @GetMapping("api/stade/{id}")
    StadeDTO getStade(@PathVariable int id){
        return stadeService.get(id);
    }

    @PostMapping("api/stade")
    Stadium addStade(@RequestBody StadeDTO body){
       return stadeService.add(body);
    }

    @PutMapping("api/stade/{id}")
    Stadium updateStade(@RequestBody StadeDTO body,@PathVariable int id){
        return stadeService.update(body,id);
    }

    @DeleteMapping("api/stade/{id}")
    String deleteStade(@PathVariable int id){
        return stadeService.delete(id);
    }

    @GetMapping("api/stades")
    List<StadeDTO> getAllStade(){
        return stadeService.getAll();

    }

    @PostMapping("api/team")
    TeamDTO addTeam(@RequestBody TeamDTO body){
        TeamDTO team = body;
        return team;
    }

    @GetMapping("api/team/{id}")
    TeamDTO getTeam(@PathVariable int id){
        return teamService.get(id);
    }
    @PutMapping("api/team/{id}")
    String updateTeam(@RequestBody String body, @PathVariable int id) {
        String team = body;
        return team;
    }
    @DeleteMapping("api/team/{id}")
    String deleteTeam(@PathVariable int id){
        return "Team delete";
    }

    @GetMapping("api/teams")
    List<TeamDTO> getAllTeams(){
        return teamService.getAll();
    }


    @GetMapping("api/types/{id}")

    String getType(@PathVariable int id){
        return TypeDTO.create(id,"parc des princes").toString();
    }

    @PostMapping("api/types")
    String addType(@RequestBody String body){
        return body;
    }
    @PutMapping("api/types/{id}")
    String updateType(@RequestBody String body,@PathVariable int id){
        return body;
    }
    @DeleteMapping("api/types/{id}")
    String deleteType(@PathVariable int id){
        return "delete";
    }
    @GetMapping("api/types")
    String getAllType(){
        return "";

    }
}
