package com.projet.scootop.scootop.service;

import com.projet.scootop.scootop.model.UserDTO;
import com.projet.scootop.scootop.repository.user.ContactRepository;
import com.projet.scootop.scootop.repository.user.UserRepository;
import com.projet.scootop.scootop.repository.user.UserTypeRepository;
import com.projet.scootop.scootop.user.Contact;
import com.projet.scootop.scootop.user.User;
import com.projet.scootop.scootop.user.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;
    public User addUser(UserDTO userDTO) {
        Contact contact=contactRepository.save(userDTO.contact);
       List<UserType> types=userDTO.types.stream().map(userType -> userTypeRepository.findById(userType.id).orElse(null)).collect(Collectors.toList());
        User user = new User(userDTO.name,userDTO.firstName,contact);
        //types.stream().map(userType -> userType.users.add(user));
        user.types.addAll(types);
        return userRepository.save(user);

    }
    public User update(UserDTO userDTO,Integer id) {
        Contact contact=contactRepository.save(userDTO.contact);
        User user = new User(userDTO.name,userDTO.firstName,contact);
        user.id=id;
        return userRepository.save(user);

    }
    public User updateEntity(User user) {
        contactRepository.save(user.contact);
        return userRepository.save(user);

    }
    public User get(Integer id){

        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAll(){

        return userRepository.findAll();
    }


    public ResponseEntity<Integer> delete(Integer id){
        User scoot = userRepository.findById(id).orElse(null);
        if(scoot==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
