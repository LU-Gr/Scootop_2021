package com.projet.scootop.scootop.service;

import com.projet.scootop.scootop.model.UserTypeDTO;
import com.projet.scootop.scootop.repository.user.UserTypeRepository;
import com.projet.scootop.scootop.user.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;
    public UserType addUserType(UserTypeDTO userTypeDTO) {
        UserType userType = new UserType(userTypeDTO.type);
        return userTypeRepository.save(userType);
    }
    public UserType update(UserTypeDTO userTypeDTO,Integer id) {
        UserType userType = new UserType(userTypeDTO.type);
        userType.id=id;
        return userTypeRepository.save(userType);
    }
    public UserType get(Integer id){

       return userTypeRepository.findById(id).orElse(null);

    }

    public List<UserType> getAll(){

        return userTypeRepository.findAll();
    }


    public String delete(Integer id){
        UserType scoot = userTypeRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        userTypeRepository.deleteById(id);

        return "Deleted";
    }

}
