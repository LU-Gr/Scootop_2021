package com.projet.scootop.service.domainuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainuser.Coach;
import com.projet.scootop.mappers.domainuser.CoachMapper;
import com.projet.scootop.model.domainuser.CoachDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainuser.CoachRepository;
import com.projet.scootop.repository.user.UserRepository;
import java.util.List;

@Service
public class CoachService {

    @Autowired
    public CoachRepository coachRepository;
    
    @Autowired
    public TeamRepository teamRepository;
    
    @Autowired
	public UserRepository userRepository;
	
	@Autowired
	private CoachMapper mapper;

    public CoachDTO add(CoachDTO coachDTO) throws Exception {
        
        Coach coach = mapper.mapTo(coachDTO);
        userRepository.save(coach.getUser());
        coachRepository.save(coach);
        return mapper.mapTo(coach);
    }
    
    public CoachDTO get(Long id){
        Coach coach = coachRepository.findById(id).orElse(null);
        return mapper.mapTo(coach);
    }
    
    public CoachDTO update(CoachDTO coachDTO) throws Exception {
        
        Coach coach = mapper.mapTo(coachDTO);
        userRepository.save(coach.getUser());
        coachRepository.save(coach);
        return mapper.mapTo(coach);
    }
    
    public List<CoachDTO> getAll(){
        List<Coach> coaches = coachRepository.findAll();
        return mapper.mapTo(coaches);
    }
    public String delete(Long id){
        Coach coach = coachRepository.findById(id).orElse(null);
        if(coach==null){
            return null;
        }
        coachRepository.deleteById(id);

        return "Deleted";
    }

}
