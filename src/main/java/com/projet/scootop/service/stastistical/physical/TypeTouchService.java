package com.projet.scootop.service.stastistical.physical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.statistical.physical.TypeTouch;
import com.projet.scootop.model.statistical.TypeTouchDTO;
import com.projet.scootop.repository.statistical.physical.TypeTouchRepository;

import java.util.List;

@Service
public class TypeTouchService {
    @Autowired
    public TypeTouchRepository typeTouchRepository;

    public TypeTouch add(TypeTouchDTO typeTouchDTO) {
        TypeTouch typeTouch=new TypeTouch(typeTouchDTO.physical);
        return typeTouchRepository.save(typeTouch);

    }
    
    public TypeTouch update(TypeTouchDTO typeTouchDTO, Long id) {
        TypeTouch typeTouch=new TypeTouch(typeTouchDTO.physical);
        typeTouch.id=id;
        return typeTouchRepository.save(typeTouch);
    }
    
    public TypeTouch get(Long id){
        return typeTouchRepository.findById(id).orElse(null);
    }
    
    public List<TypeTouch> getAll(){
        return typeTouchRepository.findAll();
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
