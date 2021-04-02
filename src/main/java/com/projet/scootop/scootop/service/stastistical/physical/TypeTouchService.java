package com.projet.scootop.scootop.service.stastistical.physical;

import com.projet.scootop.scootop.domain.stastistical.physical.TypeTouch;
import com.projet.scootop.scootop.model.statistical.TypeTouchDTO;
import com.projet.scootop.scootop.repository.statistical.physical.TypeTouchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTouchService {
    @Autowired
    public TypeTouchRepository typeTouchRepository;

    public TypeTouch add(TypeTouchDTO typeTouchDTO) {
        TypeTouch typeTouch=new TypeTouch(typeTouchDTO.physical);
        return typeTouchRepository.save(typeTouch);

    }
    public TypeTouch update(TypeTouchDTO typeTouchDTO,Integer id) {
        TypeTouch typeTouch=new TypeTouch(typeTouchDTO.physical);
        typeTouch.id=id;
        return typeTouchRepository.save(typeTouch);
    }
    public TypeTouch get(Integer id){
        return typeTouchRepository.findById(id).orElse(null);
    }
    public List<TypeTouch> getAll(){
        return typeTouchRepository.findAll();
    }
    public ResponseEntity<Integer> delete(Integer id){
        TypeTouch typeTouch = typeTouchRepository.findById(id).orElse(null);
        if(typeTouch==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        typeTouchRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
