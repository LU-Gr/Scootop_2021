package com.projet.scootop.service.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Coach;
import com.projet.scootop.mappers.user.domain.CoachMapper;
import com.projet.scootop.model.user.domain.CoachDTO;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.domain.CoachRepository;
import com.projet.scootop.service.user.UserTypeService;

import java.util.List;

@Service
public class CoachService {

    @Autowired private CoachRepository coachRepository;
    @Autowired private UserRepository userRepository;   
    @Autowired private UserTypeService userTypeService;	
	@Autowired private CoachMapper mapper;

    public CoachDTO add(CoachDTO coachDTO) throws Exception {
        Coach coach = mapper.mapTo(coachDTO);
        User user = userRepository.getOne(coach.getUser().getId());
    	user.getUserTypes().add(userTypeService.getOneByType("Coach"));
    	userRepository.save(user);
        coachRepository.save(coach);
        return mapper.mapToDTO(coach);
    }
    
    public CoachDTO get(Long id){
        Coach coach = coachRepository.findById(id).orElse(null);
        return mapper.mapToDTO(coach);
    }
    
    public CoachDTO update(CoachDTO coachDTO) throws Exception {
        
        Coach coach = mapper.mapTo(coachDTO);
        userRepository.save(coach.getUser());
        coachRepository.save(coach);
        return mapper.mapToDTO(coach);
    }
    
    public List<CoachDTO> getAll(){
        List<Coach> coaches = coachRepository.findAll();
        return mapper.mapToDTO(coaches);
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
