package com.projet.scootop.scootop.service.domainuser;

import com.projet.scootop.scootop.domain.domainuser.Chairman;
import com.projet.scootop.scootop.model.domainuser.ChairmanDTO;
import com.projet.scootop.scootop.repository.domainuser.ChairmanRepository;
import com.projet.scootop.scootop.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairmanService {

   @Autowired
    public ChairmanRepository chairmanRepository;
    public UserService userService;
    public Chairman add(ChairmanDTO chairmanDTO) throws Exception{
        userService.updateEntity(chairmanDTO.user);
        Chairman chairman=new Chairman(chairmanDTO.user);

        return chairmanRepository.save(chairman);
    }
    public Chairman get(Long id) throws Exception{
        return chairmanRepository.findById(id).orElse(null);

    }
    public Chairman update(ChairmanDTO chairmanDTO,Long id) throws Exception{
        userService.updateEntity(chairmanDTO.user);
        Chairman chairman=new Chairman(chairmanDTO.user);
        chairman.id=id;
        return chairmanRepository.save(chairman);

    }
    public List<Chairman> getAll(){
        return chairmanRepository.findAll();
    }
    public String delete(Long id){
        Chairman chairman = chairmanRepository.findById(id).orElse(null);
        if(chairman==null){
            return null;
        }
        chairmanRepository.deleteById(id);

        return "Deleted";
    }
}
