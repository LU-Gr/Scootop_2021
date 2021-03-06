package com.projet.scootop.service.user.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Chairman;
import com.projet.scootop.mappers.user.domain.ChairmanMapper;
import com.projet.scootop.model.user.domain.ChairmanDTO;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.domain.ChairmanRepository;
import com.projet.scootop.service.user.UserTypeService;

@Service
public class ChairmanService {

	@Autowired private ChairmanRepository chairmanRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private UserTypeService userTypeService;
	@Autowired private ChairmanMapper mapper;
	
    public ChairmanDTO add(ChairmanDTO chairmanDTO) throws Exception{
    	Chairman chairman = mapper.mapTo(chairmanDTO);
    	User user = userRepository.getOne(chairman.getUser().getId());
    	user.getUserTypes().add(userTypeService.getOneByType("Chairman"));
    	userRepository.save(user);
    	chairmanRepository.save(chairman);
    	return mapper.mapToDTO(chairman);
    }
    
    public ChairmanDTO get(Long id) throws Exception{
        Chairman chairman = chairmanRepository.findById(id).orElse(null);
        return mapper.mapToDTO(chairman);
    }
    
    public ChairmanDTO update(ChairmanDTO chairmanDTO) throws Exception{
    	
        Chairman chairman = mapper.mapTo(chairmanDTO);
        userRepository.save(chairman.getUser());
        chairmanRepository.save(chairman);
        return mapper.mapToDTO(chairman);

    }
    public List<ChairmanDTO> getAll(){
        List<Chairman> chairmans = chairmanRepository.findAll();
        return mapper.mapToDTO(chairmans);
    }
    
    public String delete(Long id){
        Chairman chairman = chairmanRepository.findById(id).orElse(null);
        if(chairman==null){
            return null;
        }
        chairmanRepository.deleteById(id);

        return "Deleted";
    }
}
