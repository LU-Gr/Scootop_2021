package com.projet.scootop.controller;

import com.projet.scootop.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.domain.user.UserType;
import com.projet.scootop.model.user.ContactDTO;
import com.projet.scootop.model.user.UserDTO;
import com.projet.scootop.model.user.UserTypeDTO;
import com.projet.scootop.service.user.ContactService;
import com.projet.scootop.service.user.UserService;
import com.projet.scootop.service.user.UserTypeService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserController {
	
	@Autowired private ContactService contactService;
	
	@Autowired private UserService userService;
	
	@Autowired private UserTypeService userTypeService;
	
	@PostMapping("/api/register")
    public String register(@RequestBody UserDTO userDTO, HttpServletResponse response){
	    return userService.register(userDTO, response);
    }
    
    @PostMapping("/api/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO, HttpServletResponse response) throws Exception {
	    return userService.login(userDTO, response);
    }

    @GetMapping("api/contacts")
    List<ContactDTO> getAllContacts(){
        return contactService.getAll();
    }

    @GetMapping("api/contact/{id}")
    ContactDTO getContact(@PathVariable("id") Long id){
        return contactService.get(id);
    }

    @PutMapping("api/contact/{id}")
    String updateContact(@RequestBody String body,@PathVariable("id") Long id){
        String contact = body;
        return contact;
    }
    
    @PostMapping("api/contact")
    ContactDTO addContact(@RequestBody ContactDTO body){
        return contactService.addContact(body);
    }
    
    @DeleteMapping("api/contact/{id}")
    String deleteContact(@PathVariable("id") Long id) {
        return contactService.delete(id);
    }

    // Dans l'ojet user le parametre contact, contient une methode toString. Quel valeur attend la clé ContactRepository dans la methode get  all user
    @GetMapping("api/users")
    List<UserDTO> getAllUser(){
        return userService.getAll();
    }
    
    @GetMapping("api/user/{id}")
    UserDTO getUser(@PathVariable("id") Long id){
        return userService.get(id);
    }
    
    @PutMapping("api/user/{id}")
    ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO body){
        return new ResponseEntity<>(userService.update(body), HttpStatus.OK);
    }
    
    @PostMapping("api/user")
    ResponseEntity<UserDTO> addUser(@RequestBody UserDTO body){
        return new ResponseEntity<>(userService.addUser(body), HttpStatus.OK) ;
    }
    
    @DeleteMapping("api/user/{id}")
    ResponseEntity<Integer>  deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }


    @GetMapping("api/user_type")
    List<UserTypeDTO> getAllUserType(){
        return userTypeService.getAll();
    }
    
    @GetMapping("api/user_type/{id}")
    UserTypeDTO getUserType(@PathVariable("id") Long id){
        return userTypeService.get(id);
    }
    
    @PutMapping("api/user_type/{id}")
    UserTypeDTO updateUserType(@RequestBody UserTypeDTO body){
        return userTypeService.update(body);
    }
    
    @PostMapping("api/user_type")
    UserTypeDTO addUserType(@RequestBody UserTypeDTO body){
        return userTypeService.addUserType(body);
    }
    
    @DeleteMapping("api/user_type/{id}")
    String deleteUserType(@PathVariable("id") Long id) {
        return userTypeService.delete(id);
    }
}
