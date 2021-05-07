package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.TouchType;
import com.projet.scootop.mappers.configuration.TouchTypeMapper;
import com.projet.scootop.model.configuration.TouchTypeDTO;
import com.projet.scootop.repository.configuration.TouchTypeRepository;

import java.util.List;

@Service
public class TouchTypeService {
	
    @Autowired private TouchTypeRepository typeTouchRepository;
    @Autowired private TouchTypeMapper mapper;

    public TouchTypeDTO add(TouchTypeDTO typeTouchDTO) {
        TouchType typeTouch = mapper.mapTo(typeTouchDTO);
        typeTouchRepository.save(typeTouch);
        return mapper.mapTo(typeTouch);

    }
    
    public TouchTypeDTO update(TouchTypeDTO typeTouchDTO) {
        TouchType typeTouch = mapper.mapTo(typeTouchDTO);
        typeTouchRepository.save(typeTouch);
        return mapper.mapTo(typeTouch);
    }
    
    public TouchTypeDTO get(Long id){
    	TouchType typeTouch = typeTouchRepository.findById(id).orElse(null);
        return mapper.mapTo(typeTouch);
    }
    
    public List<TouchTypeDTO> getAll(){
    	List<TouchType> typeTouches = typeTouchRepository.findAll();
        return mapper.mapTo(typeTouches);
    }
    
    public ResponseEntity<Integer> delete(Long id){
        TouchType typeTouch = typeTouchRepository.findById(id).orElse(null);
        if(typeTouch==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeTouchRepository.deleteById(id);
        return new ResponseEntity<>(id.intValue(), HttpStatus.OK);
    }

}
