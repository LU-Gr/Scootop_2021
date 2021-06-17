package com.projet.scootop.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.UserType;
import com.projet.scootop.mappers.user.UserMapper;
import com.projet.scootop.model.user.UserDTO;
import com.projet.scootop.repository.user.ContactRepository;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.UserTypeRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired private PasswordEncoder bCryptPasswordEncoder;
    @Autowired private UserRepository userRepository;
    @Autowired private ContactRepository contactRepository;
    @Autowired private UserTypeRepository userTypeRepository;
    @Autowired private UserMapper mapper;
    
    public UserDTO addUser(UserDTO userDTO) {
    	System.out.println(userDTO.toString());
        User user = mapper.mapTo(userDTO);
        System.out.println(user.toString());
        contactRepository.save(user.getContact());
        userRepository.save(user);
        return mapper.mapToDTO(user);
    }
    
    public UserDTO update(UserDTO userDTO) {
    	User user = mapper.mapTo(userDTO);
        contactRepository.save(user.getContact());
        userRepository.save(user);
        return mapper.mapToDTO(user);
    }
    
    public UserDTO get(Long id){
        User user = userRepository.findById(id).orElse(null);
        return mapper.mapToDTO(user);
    }

    public List<UserDTO> getAll(){
        List<User> users = userRepository.findAll();
        return mapper.mapToDTO(users);
    }


    public ResponseEntity<Integer> delete(Long id){
        User scoot = userRepository.findById(id).orElse(null);
        if(scoot==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.deleteById(id);
        return new ResponseEntity<>(id.intValue(), HttpStatus.OK);
    }

    public String register(UserDTO userDTO, HttpServletResponse response){
    	System.out.println(userDTO.toString());
        String password = userDTO.getPassword().toString();
        String newPassword = bCryptPasswordEncoder.encode(password);
        userDTO.setPassword(newPassword);
        User user = mapper.mapTo(userDTO);
        contactRepository.save(user.getContact());
        userRepository.save(user);
        return "{\"id\":" + user.getId() +"}"; // retourner le user

    }
    
    public ResponseEntity<UserDTO> login(UserDTO userDTO, HttpServletResponse response) throws Exception {
        String password = userDTO.getPassword().toString();
        String email = userDTO.getEmail().toString();
        
        Optional<User> user = userRepository.findByEmail(email);
        
        if(bCryptPasswordEncoder.matches(password, user.get().getPassword())){
            UserDTO dto = new UserDTO();
            dto.setEmail(email);
            
            return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
        }
        else{
            throw new Exception("email and password does not match");
        }
    }

}
