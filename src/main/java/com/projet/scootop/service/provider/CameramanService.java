package com.projet.scootop.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.provider.Cameraman;
import com.projet.scootop.mappers.provider.CameramanMapper;
import com.projet.scootop.model.provider.CameramanDTO;
import com.projet.scootop.repository.provider.CameramanRepository;
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
        return mapper.mapTo(cameraman);
    }
    
    public CameramanDTO update(CameramanDTO cameramanDTO) throws Exception {
        Cameraman cameraman= mapper.mapTo(cameramanDTO);
        cameramanRepository.save(cameraman);
        return mapper.mapTo(cameraman);
    }
    
    public CameramanDTO get(Long id){
        Cameraman cameraman = cameramanRepository.findById(id).orElse(null);
        if(cameraman==null){
            return null;
        }
        
        return mapper.mapTo(cameraman);
    }
    public List<CameramanDTO> getAll(){

        List<Cameraman> cameramans = cameramanRepository.findAll();
        return mapper.mapTo(cameramans);
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
