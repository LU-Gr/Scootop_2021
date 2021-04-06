package com.projet.scootop.scootop.service.provider;

import com.projet.scootop.scootop.domain.provider.Cameraman;
import com.projet.scootop.scootop.model.provider.CameramanDTO;
import com.projet.scootop.scootop.repository.provider.CameramanRepository;
import com.projet.scootop.scootop.repository.user.ContactRepository;
import com.projet.scootop.scootop.repository.user.UserRepository;
import com.projet.scootop.scootop.repository.user.UserTypeRepository;
import com.projet.scootop.scootop.service.user.UserService;
import com.projet.scootop.scootop.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CameramanService {
	
    public UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    public CameramanRepository cameramanRepository;
    
    public CameramanService(CameramanRepository cameramanRepository,UserService userService) {
        this.cameramanRepository = cameramanRepository;
        this.userService =userService;
    }

    public Cameraman add(CameramanDTO cameramanDTO) throws Exception {
        User newUser=userService.updateEntity(cameramanDTO.user);
        Cameraman cameraman=new Cameraman(newUser,cameramanDTO.tarif,cameramanDTO.experience);
        return cameramanRepository.save(cameraman);
    }
    
    public Cameraman update(CameramanDTO cameramanDTO, Long id) throws Exception {
        User newUser = userService.updateEntity(cameramanDTO.user);
        Cameraman cameraman=new Cameraman(newUser,cameramanDTO.tarif,cameramanDTO.experience);
        cameraman.id=id;

        return cameramanRepository.save(cameraman);
    }
    
    public CameramanDTO get(Long id){
        Cameraman cameraman = cameramanRepository.findById(id).orElse(null);
        if(cameraman==null){
            return null;
        }
        
        return CameramanDTO.get(cameraman.id, cameraman.tarif, cameraman.experience, cameraman.user);
    }
    public List<CameramanDTO> getAll(){

        List<Cameraman> cameramans = cameramanRepository.findAll();
        return cameramans.stream().map(cameraman -> CameramanDTO.get(cameraman.id, cameraman.tarif, cameraman.experience, cameraman.user)).collect(Collectors.toList());
    }
    
    public String delete(Long id){
        Cameraman cameraman = cameramanRepository.findById(id).orElse(null);
        if(cameraman==null){
            return null;
        }
        cameramanRepository.deleteById(id);
        return "Deleted";
    }

}
