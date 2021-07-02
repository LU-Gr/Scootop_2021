package com.projet.scootop.controller;

import com.projet.scootop.AuthRequest;
import com.projet.scootop.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.projet.scootop.model.user.ContactDTO;
import com.projet.scootop.model.user.LoginDTO;
import com.projet.scootop.model.user.UserDTO;
import com.projet.scootop.model.user.UserTypeDTO;
import com.projet.scootop.service.user.ContactService;
import com.projet.scootop.service.user.UserService;
import com.projet.scootop.service.user.UserTypeService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired private ContactService contactService;
	@Autowired private UserService userService;
	@Autowired private UserTypeService userTypeService;
    
    

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO, HttpServletResponse response){
        return userService.register(userDTO, response);
    }

    /*@PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody UserDTO userDTO, HttpServletResponse response) throws Exception {
        return userService.login(userDTO, response);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
       return userService.authenticate(authRequest);
    }*/

    @GetMapping("/contacts")
    List<ContactDTO> getAllContacts(){
        return contactService.getAll();
    }

    @GetMapping("/contact/{id}")
    ContactDTO getContact(@PathVariable("id") Long id){
        return contactService.get(id);
    }

    @PutMapping("/contact/{id}")
    String updateContact(@RequestBody String body,@PathVariable("id") Long id){
        String contact = body;
        return contact;
    }
    
    @PostMapping("/contact")
    ContactDTO addContact(@RequestBody ContactDTO body){
        return contactService.addContact(body);
    }
    
    @DeleteMapping("/contact/{id}")
    String deleteContact(@PathVariable("id") Long id) {
        return contactService.delete(id);
    }

    // Dans l'ojet user le parametre contact, contient une methode toString. Quel valeur attend la clé ContactRepository dans la methode get  all user
    @GetMapping("/users")
    List<UserDTO> getAllUser(){
        return userService.getAll();
    }
    
    @GetMapping("/user/{id}")
    UserDTO getUser(@PathVariable("id") Long id){
        return userService.get(id);
    }
    
    @PutMapping("/user/{id}")
    ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO body, @PathVariable Long id){
        return new ResponseEntity<>(userService.update(body), HttpStatus.OK);
    }
    
    @PostMapping("/user")
    ResponseEntity<UserDTO> addUser(@RequestBody UserDTO body){
        return new ResponseEntity<>(userService.addUser(body), HttpStatus.OK) ;
    }
    
    @DeleteMapping("/user/{id}")
    ResponseEntity<Integer>  deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }


    @GetMapping("/type")
    List<UserTypeDTO> getAllUserType(){
        return userTypeService.getAll();
    }
    
    @GetMapping("/type/{id}")
    UserTypeDTO getUserType(@PathVariable("id") Long id){
        return userTypeService.get(id);
    }
    
    @PutMapping("/type/{id}")
    UserTypeDTO updateUserType(@RequestBody UserTypeDTO body, @PathVariable Long id){
        return userTypeService.update(body);
    }
    
    @PostMapping("/type")
    UserTypeDTO addUserType(@RequestBody UserTypeDTO body){
        return userTypeService.addUserType(body);
    }
    
    @DeleteMapping("/type/{id}")
    String deleteUserType(@PathVariable("id") Long id) {
        return userTypeService.delete(id);
    }
}
