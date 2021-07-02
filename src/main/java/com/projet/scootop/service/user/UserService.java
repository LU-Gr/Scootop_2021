package com.projet.scootop.service.user;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.projet.scootop.AuthRequest;
import com.projet.scootop.JwtUtil;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.mappers.user.UserMapper;
import com.projet.scootop.model.user.LoginDTO;
import com.projet.scootop.model.user.UserDTO;
import com.projet.scootop.repository.user.ContactRepository;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.UserTypeRepository;

@Service
public class UserService {

    @Autowired private PasswordEncoder bCryptPasswordEncoder;
    @Autowired private UserRepository userRepository;
    @Autowired private ContactRepository contactRepository;
    @Autowired private UserTypeRepository userTypeRepository;
    @Autowired private UserMapper mapper;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtUtil jwtUtil;
    
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
            UserDTO dto = mapper.mapToDTO(user.get());
            //dto.setEmail(email);
            LoginDTO l = new LoginDTO();
            l.setUser(dto);
            //AuthRequest
            //String auth = authenticate(authRequest)
            
            return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
        }
        else{
            throw new Exception("email and password does not match");
        }
    }

	public String authenticate(AuthRequest authRequest) throws Exception {
		 try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		 }
	     catch (Exception ex){
	    	 throw new Exception("invalid username/password");
	     }
		 return jwtUtil.generateToken(authRequest.getUsername());
	}

}
