package com.projet.scootop.scootop.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceToolsController {

    @GetMapping("api/agence_types")
    String getAllAgenceType(){
        String agence = "[{\"name\": \"Gestions d'image & Marketing\"}]";
        return agence;
    }
    @GetMapping("api/agence_type/{id}")
    String getAgenceType(@PathVariable("id") int id){
        String agence = "{\"name\": \"Gestions d'image & Marketing\"}";
        return agence;
    }
    @PutMapping("api/agence_type/{id}")
    String updateAgenceType(@RequestBody String body,@PathVariable("id") int id){
        String agence = body;
        return agence;
    }
    @PostMapping("api/agence_type")
    String addAgenceType(@RequestBody String body){
        String agence = body;
        return agence;
    }
    @DeleteMapping("api/agence_type/{id}")
    String deleteAgenceType(@PathVariable("id") int id) {
        return "delete";
    }


    @GetMapping("api/prestations")
    String getAllPrestationType(){
        String prestationtype = "[{\"name\": \"Marketing\"}]";
        return prestationtype;
    }
    @GetMapping("api/prestation/{id}")
    String getPrestationType(@PathVariable("id") int id){
        String prestationtype = "{\"name\": \"Marketing\"}";
        return prestationtype;
    }
    @PutMapping("api/prestation/{id}")
    String updatePrestationType(@RequestBody String body,@PathVariable("id") int id){
        String prestationtype = body;
        return prestationtype;
    }
    @PostMapping("api/prestation")
    String addPrestationType(@RequestBody String body){
        String prestationtype = body;
        return prestationtype;
    }
    @DeleteMapping("api/prestation/{id}")
    String deletePrestationType(@PathVariable("id") int id) {
        return "delete";
    }


}
