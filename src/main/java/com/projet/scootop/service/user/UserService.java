package com.projet.scootop.service.user;

import java.time.LocalDate;
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
import com.projet.scootop.model.user.RegisterDTO;
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

    public ResponseEntity<LoginDTO> register(RegisterDTO userDTO, HttpServletResponse response) throws Exception{
    	System.out.println(userDTO.toString());
        String password = userDTO.getPassword().toString();
        String newPassword = bCryptPasswordEncoder.encode(password);
        userDTO.setPassword(newPassword);
        
        User user = new User();
        user.setBirthday(LocalDate.parse(userDTO.getBirthDate()));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(newPassword);
        user.getContact().setTel(userDTO.getPhoneNumber());
        contactRepository.save(user.getContact());
        userRepository.save(user);
        AuthRequest authRequest = new AuthRequest(userDTO.getEmail(), userDTO.getPassword());
        return login(authRequest, response); // retourner le user

    }
    
    public ResponseEntity<LoginDTO> login(AuthRequest authRequest, HttpServletResponse response) throws Exception {
    	System.out.println(authRequest.toString());
        String password = authRequest.getPassword().toString();
        String email = authRequest.getEmail().toString();
        
        Optional<User> user = userRepository.findByEmail(email);
        LoginDTO loginDTO = new LoginDTO();
        if(bCryptPasswordEncoder.matches(password, user.get().getPassword())){
            UserDTO dto = mapper.mapToDTO(user.get());
            //dto.setEmail(email);
            
            loginDTO.setUser(dto);
            String auth = authenticate(authRequest);
            loginDTO.setJwt(auth);
            
            
        }
        else{
        	loginDTO.setCode(401);
        	loginDTO.setMessage("Email ou mot de passe incorrect");
        }
        return new ResponseEntity<LoginDTO>(loginDTO, HttpStatus.OK);
    }

	public String authenticate(AuthRequest authRequest) throws Exception {
		 try {
			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		 }
	     catch (Exception ex){
	    	 throw new Exception("invalid username/password");
	     }
		 return jwtUtil.generateToken(authRequest.getEmail());
	}

}
