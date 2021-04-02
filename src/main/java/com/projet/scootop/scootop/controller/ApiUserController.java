package com.projet.scootop.scootop.controller;

import com.projet.scootop.scootop.model.ContactDTO;
import com.projet.scootop.scootop.model.UserDTO;
import com.projet.scootop.scootop.model.UserTypeDTO;
import com.projet.scootop.scootop.service.ContactService;
import com.projet.scootop.scootop.service.UserService;
import com.projet.scootop.scootop.service.UserTypeService;
import com.projet.scootop.scootop.user.User;
import com.projet.scootop.scootop.user.UserType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiUserController {
    private ContactService contactService;
    private UserService userService;
    private UserTypeService userTypeService;

    public ApiUserController(ContactService contactService, UserService userService, UserTypeService userTypeService) {
        super();
        this.contactService = contactService;
        this.userService = userService;
        this.userTypeService = userTypeService;
    }

    @GetMapping("api/contacts")
    List<ContactDTO> getAllContacts(){
        return contactService.getAll();
    }

    @GetMapping("api/contact/{id}")
    ContactDTO getContact(@PathVariable("id") int id){
        return contactService.get(id);
    }

    @PutMapping("api/contact/{id}")
    String updateContact(@RequestBody String body,@PathVariable("id") int id){
        String contact = body;
        return contact;
    }
    @PostMapping("api/contact")
    ContactDTO addContact(@RequestBody ContactDTO body){
        return contactService.addContact(body);
    }
    @DeleteMapping("api/contact/{id}")
    String deleteContact(@PathVariable("id") int id) {
        return contactService.delete(id);
    }



    // Dans l'ojet user le parametre contact, contient une methode toString. Quel valeur attend la clé ContactRepository dans la methode get  all user
    @GetMapping("api/users")
    List<User> getAllUser(){
        return userService.getAll();
    }
    @GetMapping("api/user/{id}")
    User getUser(@PathVariable("id") int id){
        return userService.get(id);
    }
    @PutMapping("api/user/{id}")
    ResponseEntity<User> updateUser(@RequestBody UserDTO body,@PathVariable("id") int id){
        return new ResponseEntity<>(userService.update(body,id), HttpStatus.OK);
    }
    @PostMapping("api/user")
    ResponseEntity<User> addUser(@RequestBody UserDTO body){
        return new ResponseEntity<>(userService.addUser(body), HttpStatus.OK) ;
    }
    @DeleteMapping("api/user/{id}")
    ResponseEntity<Integer>  deleteUser(@PathVariable("id") int id) {
        return userService.delete(id);
    }


    @GetMapping("api/user_type")
    List<UserType> getAllUserType(){
        return userTypeService.getAll();
    }
    @GetMapping("api/user_type/{id}")
    UserType getUserType(@PathVariable("id") int id){
        return userTypeService.get(id);
    }
    @PutMapping("api/user_type/{id}")
    UserType updateUserType(@RequestBody UserTypeDTO body,@PathVariable("id") int id){
        return userTypeService.update(body,id);
    }
    @PostMapping("api/user_type")
    UserType addUserType(@RequestBody UserTypeDTO body){
        return userTypeService.addUserType(body);
    }
    @DeleteMapping("api/user_type/{id}")
    String deleteUserType(@PathVariable("id") int id) {
        return userTypeService.delete(id);
    }



}
