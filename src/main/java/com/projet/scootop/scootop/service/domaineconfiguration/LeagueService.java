package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Division;
import com.projet.scootop.scootop.domain.domainconfiguration.League;
import com.projet.scootop.scootop.mappers.domainconfiguration.DivisionMapper;
import com.projet.scootop.scootop.model.domainconfiguration.DivisionDTO;
import com.projet.scootop.scootop.model.domainconfiguration.LeagueDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.DivisionRepository;
import com.projet.scootop.scootop.repository.domainconfiguration.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueService {
	
    @Autowired
    public LeagueRepository leagueRepository;
    
    @Autowired
    public DivisionRepository divisionsRepository;
    
    public DivisionService divisionsService;
    
    @Autowired
    private DivisionMapper divisionMapper;

    public LeagueDTO add(LeagueDTO leagueDTO){
        List<DivisionDTO> divisionsDTOS = leagueDTO.divisions;
        ArrayList<Division> divisions =  new ArrayList<>();
        League newLeague = new League(leagueDTO.name);
        League league=leagueRepository.save(newLeague);
        for (DivisionDTO divisionDTO: divisionsDTOS) {
            League league1=leagueRepository.findById(league.getId()).orElse(null);
            Division newDivision = new Division(divisionDTO.getName());
            league1.getDivisions().add(newDivision);
            divisionsRepository.save(newDivision);
            //divisionsService.add(divisionDTO,league.id);
            //Divisions newDivision = new Divisions(divisionDTO.name);

            //league.divisions.add(newDivision);
            //divisionsRepository.save(newDivision);

        }
        return leagueDTO;
    }
    public LeagueDTO get(Long id){

        League league = leagueRepository.findById(id).orElse(null);
        if(league==null){
            return null;
        }
        ArrayList<DivisionDTO> divisionDTOS=  new ArrayList<>();
        List<Division> divisions = divisionsRepository.findAllByLeagueId(id);
        for (Division division: divisions) {
            DivisionDTO newDivision = divisionMapper.mapTo(division);
            divisionDTOS.add(newDivision);
        }
        LeagueDTO leagueDTO = LeagueDTO.get(league.getId(),league.getName(),divisionDTOS);
        return leagueDTO;
    }
    public List<LeagueDTO> getAll(){

        List<League> leagues = leagueRepository.findAll();
        ArrayList<LeagueDTO> leagueDTOS=  new ArrayList<>();
        for (League league: leagues) {
            ArrayList<DivisionDTO> divisionsDTOS=  new ArrayList<>();

            List<Division> divisions = divisionsRepository.findAllByLeagueId(league.getId());
            for (Division division: divisions
            ) {
                DivisionDTO newDivision = divisionMapper.mapTo(division);
                divisionsDTOS.add(newDivision);
            }

            LeagueDTO leagueDTO = LeagueDTO.get(league.getId(),league.getName(),divisionsDTOS);
            leagueDTOS.add(leagueDTO);

        }
        return leagueDTOS;
    }
    public String delete(Long id){
        League league = leagueRepository.findById(id).orElse(null);
        if(league==null){
            return null;
        }
        //System.out.println(stade.contact.toString());
        //contactRepository.delete(stade.contact);

        leagueRepository.deleteById(id);

        return "Deleted";
    }
}
