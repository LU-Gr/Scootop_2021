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

import com.projet.scootop.model.services.tools.AgenceTypeDTO;
import com.projet.scootop.model.services.tools.PrestationTypeDTO;
import com.projet.scootop.service.services.tools.AgenceTypeService;
import com.projet.scootop.service.services.tools.PrestationTypeService;

@RequestMapping("/services/tools")
@RestController
public class ServiceToolsController {
	
	@Autowired AgenceTypeService agenceTypeService;
	@Autowired PrestationTypeService prestationTypeService;

    @GetMapping("/agence/types")
    List<AgenceTypeDTO> getAllAgenceType(){
        return agenceTypeService.getAll();
    }
    @GetMapping("/agence/type/{id}")
    AgenceTypeDTO getAgenceType(@PathVariable("id") Long id){
        return agenceTypeService.get(id);
    }
    @PutMapping("/agence/type/{id}")
    AgenceTypeDTO updateAgenceType(@RequestBody AgenceTypeDTO body, @PathVariable Long id){
        return agenceTypeService.update(body);
    }
    @PostMapping("/agence/type")
    AgenceTypeDTO addAgenceType(@RequestBody AgenceTypeDTO body){
        return agenceTypeService.add(body);
    }
    @DeleteMapping("/agence/type/{id}")
    String deleteAgenceType(@PathVariable("id") Long id) {
        return "delete";
    }


    @GetMapping("/prestations")
    List<PrestationTypeDTO> getAllPrestationType(){
        return prestationTypeService.getAll();
    }
    @GetMapping("/prestation/{id}")
    PrestationTypeDTO getPrestationType(@PathVariable("id") Long id){
        return prestationTypeService.get(id);
    }
    @PutMapping("/prestation/{id}")
    PrestationTypeDTO updatePrestationType(@RequestBody PrestationTypeDTO body, @PathVariable Long id){
        return prestationTypeService.update(body);
    }
    @PostMapping("/prestation")
    PrestationTypeDTO addPrestationType(@RequestBody PrestationTypeDTO body){
        return prestationTypeService.add(body);
    }
    @DeleteMapping("/prestation/{id}")
    String deletePrestationType(@PathVariable("id") Long id) {
        return "delete";
    }


}
