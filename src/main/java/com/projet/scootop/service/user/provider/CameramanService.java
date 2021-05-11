package com.projet.scootop.service.user.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.provider.Cameraman;
import com.projet.scootop.mappers.user.provider.CameramanMapper;
import com.projet.scootop.model.user.provider.CameramanDTO;
import com.projet.scootop.repository.user.provider.CameramanRepository;

import java.util.List;

@Service
public class CameramanService {
	
    @Autowired
    public CameramanRepository cameramanRepository;
    
    @Autowired
    private CameramanMapper mapper;

    public CameramanDTO add(CameramanDTO cameramanDTO) throws Exception {
        Cameraman cameraman = mapper.mapTo(cameramanDTO);
        cameramanRepository.save(cameraman);
        return mapper.mapToDTO(cameraman);
    }
    
    public CameramanDTO update(CameramanDTO cameramanDTO) throws Exception {
        Cameraman cameraman= mapper.mapTo(cameramanDTO);
        cameramanRepository.save(cameraman);
        return mapper.mapToDTO(cameraman);
    }
    
    public CameramanDTO get(Long id){
        Cameraman cameraman = cameramanRepository.findById(id).orElse(null);
        if(cameraman==null){
            return null;
        }
        
        return mapper.mapToDTO(cameraman);
    }
    public List<CameramanDTO> getAll(){

        List<Cameraman> cameramans = cameramanRepository.findAll();
        return mapper.mapToDTO(cameramans);
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
