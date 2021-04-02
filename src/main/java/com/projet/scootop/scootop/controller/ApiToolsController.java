package com.projet.scootop.scootop.controller;


import com.projet.scootop.scootop.domain.domaintools.CategoryType;
import com.projet.scootop.scootop.domain.domaintools.CompetitionType;
import com.projet.scootop.scootop.model.domainetools.*;
import com.projet.scootop.scootop.service.domaintools.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiToolsController {
    private SaisonService saisonService;
    private SkillsTypeService skillsTypeService;
    private SkillsFamillyService skillsFamillyService;
    private CategorieTypeService categorieTypeService;
    private CompetiitonTypeService competionTypeService;


    public ApiToolsController(SaisonService saisonService, SkillsTypeService skillsTypeService, SkillsFamillyService skillsFamillyService, CategorieTypeService categorieTypeService, CompetiitonTypeService competionTypeService) {
        super();
        this.saisonService = saisonService;
        this.skillsTypeService = skillsTypeService;
        this.skillsFamillyService = skillsFamillyService;
        this.categorieTypeService = categorieTypeService;
        this.competionTypeService = competionTypeService;
    }

    @GetMapping("api/category_type/{id}")

    CategoryType getCategoryType(@PathVariable int id){
        return categorieTypeService.get(id);
    }
    @PostMapping("api/category_type")
    CategoryType addCategoryType(@RequestBody CategoryTypeDTO body){
        return categorieTypeService.add(body);
    }
    @PutMapping("api/category_type/{id}")
    CategoryType updateCategoryType(@RequestBody CategoryTypeDTO body,@PathVariable int id){
        return categorieTypeService.update(body,id);
    }
    @DeleteMapping("api/category_type/{id}")
    String deleteCategoryType(@PathVariable int id){
        return categorieTypeService.delete(id);
    }
    @GetMapping("api/category_type_all")
    List<CategoryType> getAllCategoryType(){
        return categorieTypeService.getAll();
    }
    @GetMapping("api/competition_type/{id}")
    CompetitionType getCompetitionType(@PathVariable int id){
        return competionTypeService.get(id);
    }
    @PostMapping("api/competition_type")
    CompetitionType addCompetitionType(@RequestBody CompetitionTypeDTO body){
        return competionTypeService.add(body);
    }
    @PutMapping("api/competition_type/{id}")
    CompetitionType updateCompetitionType(@RequestBody CompetitionTypeDTO body, @PathVariable int id){
        return competionTypeService.update(body,id);
    }
    @DeleteMapping("api/competition_type/{id}")
    String deleteCompetitionType(@PathVariable int id){
        return competionTypeService.delete(id);
    }
    @GetMapping("api/competition_type_all")
    List<CompetitionType> getAllCompetitionType(){
        return competionTypeService.getAll();
    }
    @GetMapping("api/saison/{id}")

    SaisonDTO getSaison(@PathVariable int id){
        return saisonService.get(id);
    }
    @PostMapping("api/saison")
    SaisonDTO addSaison(@RequestBody SaisonDTO body){
        return saisonService.addSaison(body);
    }
    @PutMapping("api/saison/{id}")
    String updateSaison(@RequestBody String body,@PathVariable int id){
        return body;
    }
    @DeleteMapping("api/saison/{id}")
    String deleteSaison(@PathVariable int id){
        return saisonService.delete(id);
    }
    @GetMapping("api/saison")
    List<SaisonDTO> getAllSaison(){
        return saisonService.getAll();
    }
    @GetMapping("api/skillsfamily/{id}")

    SkillsFamillyDTO getSkillsFamily(@PathVariable int id){
        return skillsFamillyService.get(id);
    }
    @PostMapping("api/skillsfamily")
    SkillsFamillyDTO addSkillsFamily(@RequestBody SkillsFamillyDTO body){
        return skillsFamillyService.addSkillsFamilly(body);
    }
    @PutMapping("api/skillsfamily/{id}")
    String updateSkillsFamily(@RequestBody String body,@PathVariable int id){
        return body;
    }
    @DeleteMapping("api/skillsfamily/{id}")
    String deleteSkillsFamily(@PathVariable int id){
        return skillsFamillyService.delete(id);

    }
    @GetMapping("api/skillsfamily")
    List<SkillsFamillyDTO> getAllSkillsFamily(){
        return skillsFamillyService.getAll();
    }
    @GetMapping("api/skillstype/{id}")
    SkillsTypeDTO getSkillsType(@PathVariable int id){
        return skillsTypeService.get(id);
    }
    @PostMapping("api/skillstype")
    SkillsTypeDTO addSkillsType(@RequestBody SkillsTypeDTO body){
        return skillsTypeService.addSkillsType(body);
    }
    @PutMapping("api/skillstype/{id}")
    String updateSkillsType(@RequestBody String body,@PathVariable int id){
        return body;
    }
    @DeleteMapping("api/skillstype/{id}")
    String deleteSkillsType(@PathVariable int id){
        return skillsTypeService.delete(id);
    }
    @GetMapping("api/skillstype")
    List<SkillsTypeDTO> getAllSkillsType(){
        return skillsTypeService.getAll();
    }

}
