package com.projet.scootop.scootop.controller;

import com.projet.scootop.scootop.domain.provider.Cameraman;
import com.projet.scootop.scootop.domain.provider.WearableSociety;
import com.projet.scootop.scootop.model.ClubDTO;
import com.projet.scootop.scootop.model.provider.*;
import com.projet.scootop.scootop.service.provider.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiProviderController {

    private AgenceService agenceService;
    private AnalysteService analysteService;
    private CameramanService cameramanService;
    private ManagerService managerService;
    private MarketingAdvisorService marketingAdvisorService;
    private WearableSocietyService wearableSocietyService;

    public ApiProviderController(AgenceService agenceService, AnalysteService analysteService, CameramanService cameramanService, ManagerService managerService, MarketingAdvisorService marketingAdvisorService, WearableSocietyService wearableSocietyService) {
        super();
        this.agenceService = agenceService;
        this.analysteService = analysteService;
        this.cameramanService = cameramanService;
        this.managerService = managerService;
        this.marketingAdvisorService = marketingAdvisorService;
        this.wearableSocietyService = wearableSocietyService;
    }

    @GetMapping("api/cameramans")
    List<CameramanDTO> getAllCameramen(){
        return cameramanService.getAll();
    }
    @GetMapping("api/cameraman/{id}")
    CameramanDTO getCameraman(@PathVariable int id){
        return cameramanService.get(id);
    }
    @PostMapping("api/cameraman")
    CameramanDTO addCameraman(@RequestBody CameramanDTO body){
        CameramanDTO cameraman = body;
        return cameraman;
    }
    @PutMapping("api/cameraman/{id}")
    String updateCameraman(@RequestBody String body,@PathVariable int id) {
        String cameraman = body;
        return cameraman;
    }
    @DeleteMapping("api/cameraman/{id}")
    String deleteCameraman(@PathVariable int id){

        return "Category delete";

    }

    @GetMapping("api/agences")
    List<AgenceDTO> getAllAgences(){
        return agenceService.getAll();
    }

    @GetMapping("api/agence/{id}")
    AgenceDTO getAgence(@PathVariable int id){
        return agenceService.get(id);

    }
    @PostMapping("api/agence")
    AgenceDTO addAgence(@RequestBody AgenceDTO body){
        return agenceService.add(body);
    }

    @PutMapping("api/agence/{id}")
    String updateAgence(@RequestBody String body,@PathVariable int id){
        String agence = body;
        return agence;
    }
    @DeleteMapping("api/agence/{id}")
    String deleteAgence(@PathVariable int id){
        return agenceService.delete(id);
    }

    @GetMapping("api/analyste/{id}")
    AnalysteDTO getAnalyste(@PathVariable int id){
        return analysteService.get(id);
    }

    @PostMapping("api/analyste")
    AnalysteDTO addAnalyste(@RequestBody AnalysteDTO body) throws Exception {
        return analysteService.add(body);

    }
    @PutMapping("api/analyste/{id}")
    String updateAnalyste(@RequestBody String body,@PathVariable int id){
        String analyste = body;
        return analyste;
    }
    @DeleteMapping("api/analyste/{id}")
    String deleteAnalyste(@PathVariable int id){
        return analysteService.delete(id);

    }
    @GetMapping("api/analystes")
    List<AnalysteDTO> getAllAnalystes(){
        return analysteService.getAll();
    }
    @GetMapping("api/manager/{id}")
    ManagerDTO getManager(@PathVariable int id){
        return managerService.get(id);
    }
    @PostMapping("api/manager")
    ManagerDTO addManager(@RequestBody ManagerDTO body){
        return managerService.add(body);
    }
    @PutMapping("api/manager/{id}")
    String updateManager(@RequestBody String body,@PathVariable int id){
        String manager = body;
        return manager;
    }
    @DeleteMapping("api/manager/{id}")
    String deleteManager(@PathVariable int id){
        return managerService.delete(id);
    }

    @GetMapping("api/managers")
    List<ManagerDTO> getAllManagers(){
        return managerService.getAll();
    }
    @GetMapping("api/marketing_advisor/{id}")
    MarketingAdvisorDTO getMarketingAdvisor(@PathVariable int id){
        return marketingAdvisorService.get(id);
    }
    @PostMapping("api/marketing_advisor/{id}")
    MarketingAdvisorDTO addMarketingAdvisor(@RequestBody MarketingAdvisorDTO body) throws Exception {
        return marketingAdvisorService.add(body);
    }
    @PutMapping("api/marketing_advisor/{id}")
    String updateMarketingAdvisor(@RequestBody String body,@PathVariable int id){
        String marketingAdvisor = body;
        return marketingAdvisor;
    }
    @DeleteMapping("api/marketing_advisor/{id}")
    String deleteMarketingAdvisor(@PathVariable int id){
        return marketingAdvisorService.delete(id);

    }

    @GetMapping("api/marketing_advisors")
    List<MarketingAdvisorDTO> getAllMarketingAdvisors(){
        return marketingAdvisorService.getAll();
    }

    @GetMapping("api/wearable_society/{id}")
    WearableSocietyDTO getWearableSociety(@PathVariable int id){
        return wearableSocietyService.get(id);
    }

    @PostMapping("api/wearable_society/{id}")
    WearableSocietyDTO addWearableSociety(@RequestBody WearableSocietyDTO body, @PathVariable int id){
        WearableSocietyDTO wearableSociety = body;
        return wearableSociety;    }

    @PutMapping("api/wearable_society/{id}")
    String updateWearableSociety(@RequestBody String body,@PathVariable int id){
        String wearableSociety = body;
        return wearableSociety;

    }
    @DeleteMapping("api/wearable_society/{id}")
    String deleteWearableSociety(@PathVariable int id){
        return wearableSocietyService.delete(id);
    }

    @GetMapping("api/wearable_societies")
    List<WearableSocietyDTO> getAllWearableSocieties(){
        return wearableSocietyService.getAll();
    }

}
