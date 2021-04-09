package com.projet.scootop.scootop.service.user;

import com.projet.scootop.scootop.repository.user.UserTypeRepository;
import com.projet.scootop.scootop.domain.user.UserType;
import com.projet.scootop.scootop.model.user.UserTypeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {
	
    @Autowired
    private UserTypeRepository userTypeRepository;
    
    public UserType addUserType(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType(userTypeDTO.type);
        return userTypeRepository.save(userType);
    }
    
    public UserType update(UserTypeDTO userTypeDTO, Long id) {
        UserType userType = new UserType(userTypeDTO.type);
        userType.id=id;
        return userTypeRepository.save(userType);
    }
    
    public UserType get(Long id){
       return userTypeRepository.findById(id).orElse(null);
    }

    public List<UserType> getAll(){
        return userTypeRepository.findAll();
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
