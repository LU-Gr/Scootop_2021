package com.projet.scootop.controller;


import org.springframework.web.bind.annotation.*;

import com.projet.scootop.domain.configuration.CategoryType;
import com.projet.scootop.model.configuration.ActionTypeDTO;
import com.projet.scootop.model.configuration.CategoryTypeDTO;
import com.projet.scootop.model.tools.CompetitionDTO;
import com.projet.scootop.model.tools.SaisonDTO;
import com.projet.scootop.service.configuration.ActionTypeService;
import com.projet.scootop.service.configuration.CategorieTypeService;
import com.projet.scootop.service.tools.CompetitionService;
import com.projet.scootop.service.tools.SaisonService;

import java.util.List;


@RestController
public class ToolsController {
    private SaisonService saisonService;
    private ActionTypeService actionTypeService;
    private CategorieTypeService categorieTypeService;
    private CompetitionService competionTypeService;


    public ToolsController(SaisonService saisonService, ActionTypeService skillsFamillyService, CategorieTypeService categorieTypeService, CompetitionService competionTypeService) {
        super();
        this.saisonService = saisonService;
        this.actionTypeService = skillsFamillyService;
        this.categorieTypeService = categorieTypeService;
        this.competionTypeService = competionTypeService;
    }

    @GetMapping("api/category_type/{id}")
    CategoryType getCategoryType(@PathVariable Long id){
        return categorieTypeService.get(id);
    }
    
    @PostMapping("api/category_type")
    CategoryType addCategoryType(@RequestBody CategoryTypeDTO body){
        return categorieTypeService.add(body);
    }
    
    @PutMapping("api/category_type")
    CategoryType updateCategoryType(@RequestBody CategoryTypeDTO body){
        return categorieTypeService.update(body);
    }
    
    @DeleteMapping("api/category_type/{id}")
    String deleteCategoryType(@PathVariable Long id){
        return categorieTypeService.delete(id);
    }
    
    @GetMapping("api/category_type_all")
    List<CategoryType> getAllCategoryType(){
        return categorieTypeService.getAll();
    }
    
    @GetMapping("api/competition_type/{id}")
    CompetitionDTO getCompetitionType(@PathVariable Long id){
        return competionTypeService.get(id);
    }
    
    @PostMapping("api/competition_type")
    CompetitionDTO addCompetitionType(@RequestBody CompetitionDTO body){
        return competionTypeService.add(body);
    }
    
    @PutMapping("api/competition_type")
    CompetitionDTO updateCompetitionType(@RequestBody CompetitionDTO body){
        return competionTypeService.update(body);
    }
    
    @DeleteMapping("api/competition_type/{id}")
    String deleteCompetitionType(@PathVariable Long id){
        return competionTypeService.delete(id);
    }
    
    @GetMapping("api/competition_type_all")
    List<CompetitionDTO> getAllCompetitionType(){
        return competionTypeService.getAll();
    }
    
    @GetMapping("api/saison/{id}")
    SaisonDTO getSaison(@PathVariable Long id){
        return saisonService.get(id);
    }
    
    @PostMapping("api/saison")
    SaisonDTO addSaison(@RequestBody SaisonDTO body){
        return saisonService.addSaison(body);
    }
    
    @PutMapping("api/saison/{id}")
    String updateSaison(@RequestBody String body,@PathVariable Long id){
        return body;
    }
    
    @DeleteMapping("api/saison/{id}")
    String deleteSaison(@PathVariable Long id){
        return saisonService.delete(id);
    }
    
    @GetMapping("api/saison")
    List<SaisonDTO> getAllSaison(){
        return saisonService.getAll();
    }
    
    @GetMapping("api/skillsfamily/{id}")
    ActionTypeDTO getSkillsFamily(@PathVariable Long id){
        return actionTypeService.get(id);
    }
    
    @PostMapping("api/skillsfamily")
    ActionTypeDTO addSkillsFamily(@RequestBody ActionTypeDTO body){
        return actionTypeService.addSkill(body);
    }
    
    @PutMapping("api/skillsfamily/{id}")
    String updateSkillsFamily(@RequestBody String body,@PathVariable Long id){
        return body;
    }
    
    @DeleteMapping("api/skillsfamily/{id}")
    String deleteSkillsFamily(@PathVariable Long id){
        return actionTypeService.delete(id);
    }
    
    @GetMapping("api/skillsfamily")
    List<ActionTypeDTO> getAllSkillsFamily(){
        return actionTypeService.getAll();
    }

}
