package com.projet.scootop.service.domainuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainuser.Chairman;
import com.projet.scootop.model.domainuser.ChairmanDTO;
import com.projet.scootop.repository.domainuser.ChairmanRepository;
import com.projet.scootop.service.user.UserService;

import java.util.List;

@Service
public class ChairmanService {

   @Autowired
    public ChairmanRepository chairmanRepository;
    public UserService userService;
    public Chairman add(ChairmanDTO chairmanDTO) throws Exception{
        userService.updateEntity(chairmanDTO.getUser());
        Chairman chairman=new Chairman(chairmanDTO.getUser());

        return chairmanRepository.save(chairman);
    }
    public Chairman get(Long id) throws Exception{
        return chairmanRepository.findById(id).orElse(null);

    }
    public Chairman update(ChairmanDTO chairmanDTO,Long id) throws Exception{
        userService.updateEntity(chairmanDTO.getUser());
        Chairman chairman=new Chairman(chairmanDTO.getUser());
        chairman.setId(id);
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
