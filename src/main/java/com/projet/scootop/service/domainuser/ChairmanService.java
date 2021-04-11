package com.projet.scootop.service.domainuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainuser.Chairman;
import com.projet.scootop.mappers.domainuser.ChairmanMapper;
import com.projet.scootop.model.domainuser.ChairmanDTO;
import com.projet.scootop.repository.domainuser.ChairmanRepository;
import com.projet.scootop.repository.user.UserRepository;

import java.util.List;

@Service
public class ChairmanService {

	@Autowired
    public ChairmanRepository chairmanRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	private ChairmanMapper mapper;
	
    public ChairmanDTO add(ChairmanDTO chairmanDTO) throws Exception{
    	Chairman chairman = mapper.mapTo(chairmanDTO);
    	userRepository.save(chairman.getUser());
    	chairmanRepository.save(chairman);
    	return mapper.mapTo(chairman);
    }
    
    public ChairmanDTO get(Long id) throws Exception{
        Chairman chairman = chairmanRepository.findById(id).orElse(null);
        return mapper.mapTo(chairman);
    }
    
    public ChairmanDTO update(ChairmanDTO chairmanDTO) throws Exception{
    	
        Chairman chairman = mapper.mapTo(chairmanDTO);
        userRepository.save(chairman.getUser());
        chairmanRepository.save(chairman);
        return mapper.mapTo(chairman);

    }
    public List<ChairmanDTO> getAll(){
        List<Chairman> chairmans = chairmanRepository.findAll();
        return mapper.mapTo(chairmans);
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
