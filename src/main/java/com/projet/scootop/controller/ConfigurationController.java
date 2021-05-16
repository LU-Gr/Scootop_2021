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

import com.projet.scootop.model.configuration.ActionTypeDTO;
import com.projet.scootop.model.configuration.CategoryDTO;
import com.projet.scootop.model.configuration.CategoryTypeDTO;
import com.projet.scootop.model.configuration.CompetitionTypeDTO;
import com.projet.scootop.model.configuration.DivisionDTO;
import com.projet.scootop.model.configuration.LeagueDTO;
import com.projet.scootop.model.configuration.PosteDTO;
import com.projet.scootop.model.configuration.StadeDTO;
import com.projet.scootop.model.configuration.TouchTypeDTO;
import com.projet.scootop.service.configuration.ActionTypeService;
import com.projet.scootop.service.configuration.CategoryService;
import com.projet.scootop.service.configuration.CategoryTypeService;
import com.projet.scootop.service.configuration.CompetitionTypeService;
import com.projet.scootop.service.configuration.DivisionService;
import com.projet.scootop.service.configuration.LeagueService;
import com.projet.scootop.service.configuration.PosteService;
import com.projet.scootop.service.configuration.StadeService;
import com.projet.scootop.service.configuration.TouchTypeService;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {
	
	@Autowired private ActionTypeService actionTypeService;
	@Autowired private CategoryService categoryService;
	@Autowired private CategoryTypeService categoryTypeService;
	@Autowired private CompetitionTypeService competitionTypeService;
	@Autowired private DivisionService divisionsService;
	@Autowired private LeagueService leagueService;
	@Autowired private PosteService posteService;
	@Autowired private StadeService stadeService;
	@Autowired private TouchTypeService touchTypeService;
	
	//GET ONE
	@GetMapping("/action/type/{id}")
    ActionTypeDTO getActionType(@PathVariable Long id){
        return actionTypeService.get(id);
    }
	
	@GetMapping("/category/{id}")
    CategoryDTO getCategory(@PathVariable Long id){
        return categoryService.get(id);
    }
	
	@GetMapping("/category/type/{id}")
    CategoryTypeDTO getCategoryType(@PathVariable Long id){
        return categoryTypeService.get(id);
    }
	
	@GetMapping("/competition/type/{id}")
    CompetitionTypeDTO getCompetitionType(@PathVariable Long id){
        return competitionTypeService.get(id);
    }
	
	@GetMapping("/division/{id}")
    DivisionDTO getDivision(@PathVariable("id") Long id){
        return divisionsService.get(id);
    }
    
    @GetMapping("/league/{id}")
    LeagueDTO getLeague(@PathVariable("id") Long id){
        return leagueService.get(id);
    }
    
    @GetMapping("/poste/{id}")
    PosteDTO getPoste(@PathVariable Long id){
        return posteService.get(id);
    }
    
    @GetMapping("/stade/{id}")
    StadeDTO getStade(@PathVariable Long id){
        return stadeService.get(id);
    }
    
    @GetMapping("/touch/type/{id}")
    TouchTypeDTO getType(@PathVariable Long id){
        return touchTypeService.get(id);
    }
    
    
	
	//GET ALL
	@GetMapping("/action/types")
    List<ActionTypeDTO> getAllActionType(){
        return actionTypeService.getAll();
    }
	
	@GetMapping("/categories")
    List<CategoryDTO> getAllCategory(){
        return categoryService.getAll();
    }
	
	@GetMapping("/category/types")
    List<CategoryTypeDTO> getAllCategoryType(){
        return categoryTypeService.getAll();
    }
	
	@GetMapping("/competition/types")
    List<CompetitionTypeDTO> getAllCompetitionType(){
        return competitionTypeService.getAll();
    }
	
	@GetMapping("/divisions")
    List<DivisionDTO> getAllDivisions(){
        return divisionsService.getAll();
    }
    
    @GetMapping("/leagues")
    List<LeagueDTO> getAllLeagues(){
        return leagueService.getAll();
    }
    
    @GetMapping("/postes")
    List<PosteDTO> getAllPoste(){
        return posteService.getAll();
    }
    
    @GetMapping("/stades")
    List<StadeDTO> getAllStade(){
        return stadeService.getAll();
    }
    
    @GetMapping("/touch/types")
    List<TouchTypeDTO> getAllType(){
        return touchTypeService.getAll();
    }
    
    
    
	
	//CREATE
	@PostMapping("/action/type")
    ActionTypeDTO addActionType(@RequestBody ActionTypeDTO body){
        return actionTypeService.addSkill(body);
    }
	
	@PostMapping("/category")
	CategoryDTO addCategory(@RequestBody CategoryDTO body){
		return categoryService.add(body);
    }
	
	@PostMapping("/category/type")
    CategoryTypeDTO addCategoryType(@RequestBody CategoryTypeDTO body){
        return categoryTypeService.add(body);
    }
	
	@PostMapping("/competition/type")
    CompetitionTypeDTO addCompetitionType(@RequestBody CompetitionTypeDTO body){
        return competitionTypeService.add(body);
    }
	
	@PostMapping("/division")
    DivisionDTO uploadDivision(@RequestBody DivisionDTO body){
        return null;//divisionsService.add(body,1);
    }
    
    @PostMapping("/league")
    LeagueDTO addLeague(@RequestBody LeagueDTO body){
        return leagueService.add(body);
    }
    @PostMapping("/poste")
    PosteDTO addPoste(@RequestBody PosteDTO body){
        return posteService.addPoste(body);
    }
    
    @PostMapping("/stade")
    StadeDTO addStade(@RequestBody StadeDTO body){
       return stadeService.add(body);
    }
    
    @PostMapping("/touch/type")
    TouchTypeDTO addType(@RequestBody TouchTypeDTO body){
        return touchTypeService.add(body);
    }
	
	
    
    
    
	//UPDATE
	@PutMapping("/action/type")
	ActionTypeDTO updateActionType(@RequestBody ActionTypeDTO body){
        return actionTypeService.update(body);
    }
	
	@PutMapping("/category")
	CategoryDTO updateCategory(@RequestBody CategoryDTO body){
		return categoryService.update(body);
    }
	
	@PutMapping("/category/type")
    CategoryTypeDTO updateCategoryType(@RequestBody CategoryTypeDTO body){
        return categoryTypeService.update(body);
    }
	
	@PutMapping("/competition/type")
    CompetitionTypeDTO updateCompetitionType(@RequestBody CompetitionTypeDTO body){
        return competitionTypeService.update(body);
    }
	
	@PutMapping("/division")
    DivisionDTO updateDivision(@RequestBody DivisionDTO body){
        return divisionsService.update(body);
    }
    
    @PutMapping("/league")
    LeagueDTO updateLeague(@RequestBody LeagueDTO body){
        return leagueService.update(body);
    }
    
    @PutMapping("/poste")
    PosteDTO updatePoste(@RequestBody PosteDTO body){
        return posteService.update(body);
    }
    
    @PutMapping("/stade")
    StadeDTO updateStade(@RequestBody StadeDTO body){
        return stadeService.update(body);
    }
    
    @PutMapping("/touch/types")
    TouchTypeDTO updateType(@RequestBody TouchTypeDTO body){
        return touchTypeService.update(body);
    }
    
    
    
	
	//DELETE
	@DeleteMapping("/actionType/{id}")
    String deleteActionType(@PathVariable Long id){
        return actionTypeService.delete(id);
    }
    
    @DeleteMapping("/category/{id}")
    String deleteCategory(@PathVariable Long id){
        return categoryService.delete(id);
    }
    
    @DeleteMapping("/categorytype/{id}")
    String deleteCategoryType(@PathVariable Long id){
        return categoryTypeService.delete(id);
    }

    @DeleteMapping("/competitiontype/{id}")
    String deleteCompetitionType(@PathVariable Long id){
        return competitionTypeService.delete(id);
    }
    
    @DeleteMapping("/division/{id}")
    String deleteDivision(@PathVariable("id") Long id){
        return divisionsService.delete(id);
    }
    
    @DeleteMapping("/league/{id}")
    String deleteLeague(@PathVariable("id") Long id){
        return leagueService.delete(id);
    }
    
    @DeleteMapping("/poste/{id}")
    String deletePoste(@PathVariable Long id){
        return posteService.delete(id);
    }
    
    @DeleteMapping("/stade/{id}")
    String deleteStade(@PathVariable Long id){
        return stadeService.delete(id);
    }
    
    @DeleteMapping("/touch/types/{id}")
    String deleteType(@PathVariable Long id){
        return "delete";
    }
    
    
}
