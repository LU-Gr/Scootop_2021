package com.projet.scootop.scootop.controller;


import com.projet.scootop.scootop.domain.domaintools.CategoryType;
import com.projet.scootop.scootop.domain.domaintools.Competition;
import com.projet.scootop.scootop.model.domaintools.*;
import com.projet.scootop.scootop.service.domaintools.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ToolsController {
    private SaisonService saisonService;
    private SkillTypeService skillsTypeService;
    private SkillService skillsFamillyService;
    private CategorieTypeService categorieTypeService;
    private CompetitionService competionTypeService;


    public ToolsController(SaisonService saisonService, SkillTypeService skillsTypeService, SkillService skillsFamillyService, CategorieTypeService categorieTypeService, CompetitionService competionTypeService) {
        super();
        this.saisonService = saisonService;
        this.skillsTypeService = skillsTypeService;
        this.skillsFamillyService = skillsFamillyService;
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
    @PutMapping("api/category_type/{id}")
    CategoryType updateCategoryType(@RequestBody CategoryTypeDTO body,@PathVariable Long id){
        return categorieTypeService.update(body,id);
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
    Competition getCompetitionType(@PathVariable Long id){
        return competionTypeService.get(id);
    }
    @PostMapping("api/competition_type")
    Competition addCompetitionType(@RequestBody CompetitionDTO body){
        return competionTypeService.add(body);
    }
    @PutMapping("api/competition_type/{id}")
    Competition updateCompetitionType(@RequestBody CompetitionDTO body, @PathVariable Long id){
        return competionTypeService.update(body,id);
    }
    @DeleteMapping("api/competition_type/{id}")
    String deleteCompetitionType(@PathVariable Long id){
        return competionTypeService.delete(id);
    }
    @GetMapping("api/competition_type_all")
    List<Competition> getAllCompetitionType(){
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

    SkillDTO getSkillsFamily(@PathVariable Long id){
        return skillsFamillyService.get(id);
    }
    @PostMapping("api/skillsfamily")
    SkillDTO addSkillsFamily(@RequestBody SkillDTO body){
        return skillsFamillyService.addSkill(body);
    }
    @PutMapping("api/skillsfamily/{id}")
    String updateSkillsFamily(@RequestBody String body,@PathVariable Long id){
        return body;
    }
    @DeleteMapping("api/skillsfamily/{id}")
    String deleteSkillsFamily(@PathVariable Long id){
        return skillsFamillyService.delete(id);

    }
    @GetMapping("api/skillsfamily")
    List<SkillDTO> getAllSkillsFamily(){
        return skillsFamillyService.getAll();
    }
    @GetMapping("api/skillstype/{id}")
    SkillTypeDTO getSkillsType(@PathVariable Long id){
        return skillsTypeService.get(id);
    }
    @PostMapping("api/skillstype")
    SkillTypeDTO addSkillsType(@RequestBody SkillTypeDTO body){
        return skillsTypeService.addSkillType(body);
    }
    @PutMapping("api/skillstype/{id}")
    String updateSkillsType(@RequestBody String body,@PathVariable Long id){
        return body;
    }
    @DeleteMapping("api/skillstype/{id}")
    String deleteSkillsType(@PathVariable Long id){
        return skillsTypeService.delete(id);
    }
    @GetMapping("api/skillstype")
    List<SkillTypeDTO> getAllSkillsType(){
        return skillsTypeService.getAll();
    }

}
