package com.projet.scootop.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.UserType;
import com.projet.scootop.mappers.user.UserTypeMapper;
import com.projet.scootop.model.user.UserTypeDTO;
import com.projet.scootop.repository.user.UserTypeRepository;

import java.util.List;

@Service
public class UserTypeService {
	
    @Autowired private UserTypeRepository userTypeRepository;
    @Autowired private UserTypeMapper mapper;
    
    public UserType getOneByType(String type) {
    	return userTypeRepository.findByType(type);
    }
    
    public UserTypeDTO addUserType(UserTypeDTO userTypeDTO) {
        UserType userType = mapper.mapTo(userTypeDTO);
        userTypeRepository.save(userType);
        return mapper.mapToDTO(userType);
    }
    
    public UserTypeDTO update(UserTypeDTO userTypeDTO) {
    	UserType userType = mapper.mapTo(userTypeDTO);
        userTypeRepository.save(userType);
        return mapper.mapToDTO(userType);
    }
    
    public UserTypeDTO get(Long id){
    	UserType types = userTypeRepository.findById(id).orElse(null);
    	return mapper.mapToDTO(types);
    }

    public List<UserTypeDTO> getAll(){
    	List<UserType> types = userTypeRepository.findAll();
        return mapper.mapToDTO(types);
    }


    public String delete(Long id){
        UserType scoot = userTypeRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        userTypeRepository.deleteById(id);

        return "Deleted";
    }

}
