package com.projet.scootop.scootop.service.domainuser;

import com.projet.scootop.scootop.domain.domainuser.Chairman;
import com.projet.scootop.scootop.model.domainuser.ChairmanDTO;
import com.projet.scootop.scootop.repository.domainuser.ChairmanRepository;
import com.projet.scootop.scootop.service.UserService;
import com.projet.scootop.scootop.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
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
    public Chairman get(Integer id) throws Exception{
        return chairmanRepository.findById(id).orElse(null);

    }
    public Chairman update(ChairmanDTO chairmanDTO,Integer id) throws Exception{
        userService.updateEntity(chairmanDTO.user);
        Chairman chairman=new Chairman(chairmanDTO.user);
        chairman.id=id;
        return chairmanRepository.save(chairman);

    }
    public List<Chairman> getAll(){
        return chairmanRepository.findAll();
    }
    public String delete(Integer id){
        Chairman chairman = chairmanRepository.findById(id).orElse(null);
        if(chairman==null){
            return null;
        }
        chairmanRepository.deleteById(id);

        return "Deleted";
    }
}
