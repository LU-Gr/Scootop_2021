package com.projet.scootop.service.statistical.physical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.physical.TypeTouch;
import com.projet.scootop.mappers.statistical.physical.TypeTouchMapper;
import com.projet.scootop.model.statistical.physical.TypeTouchDTO;
import com.projet.scootop.repository.statistical.physical.TypeTouchRepository;

import java.util.List;

@Service
public class TypeTouchService {
	
    @Autowired private TypeTouchRepository typeTouchRepository;
    @Autowired private TypeTouchMapper mapper;

    public TypeTouchDTO add(TypeTouchDTO typeTouchDTO) {
        TypeTouch typeTouch = mapper.mapTo(typeTouchDTO);
        typeTouchRepository.save(typeTouch);
        return mapper.mapTo(typeTouch);

    }
    
    public TypeTouchDTO update(TypeTouchDTO typeTouchDTO) {
        TypeTouch typeTouch = mapper.mapTo(typeTouchDTO);
        typeTouchRepository.save(typeTouch);
        return mapper.mapTo(typeTouch);
    }
    
    public TypeTouchDTO get(Long id){
    	TypeTouch typeTouch = typeTouchRepository.findById(id).orElse(null);
        return mapper.mapTo(typeTouch);
    }
    
    public List<TypeTouchDTO> getAll(){
    	List<TypeTouch> typeTouches = typeTouchRepository.findAll();
        return mapper.mapTo(typeTouches);
    }
    
    public ResponseEntity<Integer> delete(Long id){
        TypeTouch typeTouch = typeTouchRepository.findById(id).orElse(null);
        if(typeTouch==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeTouchRepository.deleteById(id);
        return new ResponseEntity<>(id.intValue(), HttpStatus.OK);
    }

}
