package com.projet.scootop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.model.user.provider.*;
import com.projet.scootop.service.user.provider.*;

import java.util.List;

@RequestMapping("/user/provider")
@RestController
public class UserProviderController {

    @Autowired private AgenceService agenceService;
    @Autowired private AnalysteService analysteService;
    @Autowired private CameramanService cameramanService;
    @Autowired private ManagerService managerService;
    @Autowired private MarketingAdvisorService marketingAdvisorService;

    
    //GET ALL
    @GetMapping("/cameramans")
    List<CameramanDTO> getCameramen(){
        return cameramanService.getAll();
    }
    
    @GetMapping("/agences")
    List<AgenceDTO> getAgences(){
        return agenceService.getAll();
    }
    
    @GetMapping("/analysts")
    List<AnalysteDTO> getAnalysts(){
        return analysteService.getAll();
    }
    
    @GetMapping("/managers")
    List<ManagerDTO> getManagers(){
        return managerService.getAll();
    }
    
    @GetMapping("/marketing/advisors")
    List<MarketingAdvisorDTO> getMarketingAdvisors(){
        return marketingAdvisorService.getAll();
    }
    
    
    
    
    
    //GET ONE
    @GetMapping("/cameraman/{id}")
    CameramanDTO getCameraman(@PathVariable Long id){
        return cameramanService.get(id);
    }
    
    @GetMapping("/agence/{id}")
    AgenceDTO getAgence(@PathVariable Long id){
        return agenceService.get(id);
    }
    
    @GetMapping("/analyst/{id}")
    AnalysteDTO getAnalyst(@PathVariable Long id){
        return analysteService.get(id);
    }
    
    @GetMapping("/manager/{id}")
    ManagerDTO getManager(@PathVariable Long id){
        return managerService.get(id);
    }
    
    @GetMapping("/marketing/advisor/{id}")
    MarketingAdvisorDTO getMarketingAdvisor(@PathVariable Long id){
        return marketingAdvisorService.get(id);
    }
    
    
    
    
    
    
    
    
    //CREATE
    @PostMapping("/cameraman")
    CameramanDTO addCameraman(@RequestBody CameramanDTO body) throws Exception{
        return cameramanService.add(body);
    }
    
    @PostMapping("/agence")
    AgenceDTO addAgence(@RequestBody AgenceDTO body){
        return agenceService.add(body);
    }
    
    @PostMapping("/analyst")
    AnalysteDTO addAnalyst(@RequestBody AnalysteDTO body) throws Exception {
        return analysteService.add(body);
    }
    
    @PostMapping("/manager")
    ManagerDTO addManager(@RequestBody ManagerDTO body){
        return managerService.add(body);
    }
    
    @PostMapping("/marketing/advisor/{id}")
    MarketingAdvisorDTO addMarketingAdvisor(@RequestBody MarketingAdvisorDTO body) throws Exception {
        return marketingAdvisorService.add(body);
    }
    
    
    
    
    
    
    
    
    //UPDATE
    @PutMapping("/cameraman")
    CameramanDTO updateCameraman(@RequestBody CameramanDTO body) throws Exception {
        return cameramanService.update(body);
    }
    
    @PutMapping("/agence")
    AgenceDTO updateAgence(@RequestBody AgenceDTO body){
        return agenceService.update(body);
    }
    
    @PutMapping("/analyst")
    AnalysteDTO updateAnalyst(@RequestBody AnalysteDTO body){
        return analysteService.update(body);
    }
    
    @PutMapping("/manager")
    ManagerDTO updateManager(@RequestBody ManagerDTO body){
        return managerService.update(body);
    }
    
    @PutMapping("/marketing/advisor")
    MarketingAdvisorDTO updateMarketingAdvisor(@RequestBody MarketingAdvisorDTO body){
        return marketingAdvisorService.update(body);
    }
    
    
    
    
    //DELETE
    @DeleteMapping("/cameraman/{id}")
    String deleteCameraman(@PathVariable Long id){
        return cameramanService.delete(id);
    }

    @DeleteMapping("/agence/{id}")
    String deleteAgence(@PathVariable Long id){
        return agenceService.delete(id);
    }

    @DeleteMapping("/analyst/{id}")
    String deleteAnalyst(@PathVariable Long id){
        return analysteService.delete(id);
    }
   
    @DeleteMapping("/manager/{id}")
    String deleteManager(@PathVariable Long id){
        return managerService.delete(id);
    }

    @DeleteMapping("/marketing/advisor/{id}")
    String deleteMarketingAdvisor(@PathVariable Long id){
        return marketingAdvisorService.delete(id);
    }

}
