package com.projet.scootop.controller;

import org.springframework.web.bind.annotation.*;

import com.projet.scootop.model.configuration.*;
import com.projet.scootop.model.tools.ClubDTO;
import com.projet.scootop.model.tools.TeamDTO;
import com.projet.scootop.repository.tools.ClubRepository;
import com.projet.scootop.service.configuration.*;
import com.projet.scootop.service.tools.ClubService;
import com.projet.scootop.service.tools.TeamService;

import java.util.List;

@RestController
public class DomainConfigController {
    private StadeService stadeService;
    private LeagueService leagueService;
    private CategoryService categoryService;
    private ClubService clubService;
    private DivisionService divisionsService;
    private PosteService posteService;
    private TeamService teamService;
    private CompetitionTypeService typeService;


    public DomainConfigController(StadeService stadeService, LeagueService leagueService, CategoryService categoryService, ClubService clubService, DivisionService divisionsService, PosteService posteService, TeamService teamService, CompetitionTypeService typeService) {
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
    CategoryDTO getCategory(@PathVariable Long id){
        return categoryService.get(id);
    }

    @PostMapping("api/category")
    CategoryDTO addCategory(@RequestBody CategoryDTO body){
        CategoryDTO category = body;
        return category;
    }

    @PutMapping("api/category/{id}")
    String updateCategory(@RequestBody String body,@PathVariable Long id){
        String category = body;
        return category;
    }

    @DeleteMapping("api/category/{id}")
    String deleteCategory(@PathVariable Long id){

        return "Category delete";
    }


    @GetMapping("api/clubs")
    List<ClubDTO> getAllClubs(){ return clubService.getAll();}

    @GetMapping("api/club/{id}")
    ClubDTO getClub(@PathVariable Long id){
        return clubService.get(id);
    }

    @PostMapping("api/club")
    ClubDTO addClub(@RequestBody ClubDTO club) {
        return clubService.add(club);
    }

    @PutMapping("api/club/{id}")
    String updateClub(@RequestBody String body,@PathVariable Long id) {
        String club = body;
        return club;
    }

    @DeleteMapping("api/club/{id}")
    String deleteClub(@PathVariable Long id){
        return clubService.delete(id);
    }


    @GetMapping("api/division/{id}")
    DivisionDTO getDivision(@PathVariable("id") Long id){
        return divisionsService.get(id);
    }
    @PutMapping("api/division/{id}")
    String uploadDivision(@RequestBody String body, @PathVariable("id") Long id){
        return body;
    }
    @PostMapping("api/division")
    DivisionDTO uploadDivision(@RequestBody DivisionDTO body){
        return null;//divisionsService.add(body,1);
    }
    @DeleteMapping("api/division/{id}")
    String deleteDivision(@PathVariable("id") Long id){
        return divisionsService.delete(id);
    }
    @GetMapping("api/divisions")
    List<DivisionDTO> getAllDivisions(){
        return divisionsService.getAll();
    }

    @GetMapping("api/league/{id}")
    LeagueDTO getLeague(@PathVariable("id") Long id){
        return leagueService.get(id);

    }
    @PutMapping("api/league/{id}")
    String uploadLeague(@RequestBody String body, @PathVariable("id") Long id){
        return body;
    }
    @PostMapping("api/league")
    LeagueDTO addLeague(@RequestBody LeagueDTO body){

        return leagueService.add(body);
    }
    @DeleteMapping("api/league/{id}")
    String deleteLeague(@PathVariable("id") Long id){
        return leagueService.delete(id);
    }
    @GetMapping("api/leagues")
    List<LeagueDTO> getAllLeagues(){
        return leagueService.getAll();
    }

    @GetMapping("api/poste/{id}")
    PosteDTO getPoste(@PathVariable Long id){
        return posteService.get(id);
    }

    @PostMapping("api/poste")
    PosteDTO addPoste(@RequestBody PosteDTO body){
        return posteService.addPoste(body);
    }

    @PutMapping("api/poste/{id}")
    PosteDTO updatePoste(@RequestBody PosteDTO body,@PathVariable Long id){
        return posteService.update(body,id);
    }

    @DeleteMapping("api/poste/{id}")
    String deletePoste(@PathVariable Long id){
        return posteService.delete(id);
    }

    @GetMapping("api/postes")
    List<PosteDTO> getAllPoste(){
        return posteService.getAll();

    }

    @GetMapping("api/stade/{id}")
    StadeDTO getStade(@PathVariable Long id){
        return stadeService.get(id);
    }

    @PostMapping("api/stade")
    StadeDTO addStade(@RequestBody StadeDTO body){
       return stadeService.add(body);
    }

    @PutMapping("api/stade/{id}")
    StadeDTO updateStade(@RequestBody StadeDTO body){
        return stadeService.update(body);
    }

    @DeleteMapping("api/stade/{id}")
    String deleteStade(@PathVariable Long id){
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
    TeamDTO getTeam(@PathVariable Long id){
        return teamService.get(id);
    }
    @PutMapping("api/team/{id}")
    String updateTeam(@RequestBody String body, @PathVariable Long id) {
        String team = body;
        return team;
    }
    @DeleteMapping("api/team/{id}")
    String deleteTeam(@PathVariable Long id){
        return "Team delete";
    }

    @GetMapping("api/teams")
    List<TeamDTO> getAllTeams(){
        return teamService.getAll();
    }


    @GetMapping("api/types/{id}")

    String getType(@PathVariable Long id){
        return CompetitionTypeDTO.create(id,"parc des princes").toString();
    }

    @PostMapping("api/types")
    String addType(@RequestBody String body){
        return body;
    }
    @PutMapping("api/types/{id}")
    String updateType(@RequestBody String body,@PathVariable Long id){
        return body;
    }
    @DeleteMapping("api/types/{id}")
    String deleteType(@PathVariable Long id){
        return "delete";
    }
    @GetMapping("api/types")
    String getAllType(){
        return "";

    }
}
