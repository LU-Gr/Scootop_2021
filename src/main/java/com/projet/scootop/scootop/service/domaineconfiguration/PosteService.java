package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.domain.domainconfiguration.Poste;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.model.ContactDTO;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.domainconfiguration.PosteDTO;
import com.projet.scootop.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.PosteRepository;
import com.projet.scootop.scootop.user.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PosteService {
    @Autowired
    private PosteRepository posteRepository;

    public Poste addPoste(PosteDTO posteDTO) {

        Poste poste = new Poste(posteDTO.name,posteDTO.playerList);
        return posteRepository.save(poste);

    }
    public PosteDTO get(Integer id) {

        Poste poste = posteRepository.findById(id).orElse(null);
        if(poste==null){
            return null;
        }
        return PosteDTO.get(poste.id, poste.name,poste.players);

    }
    public Poste update(PosteDTO posteDTO,Integer id) {

        Poste poste=new Poste(posteDTO.name,posteDTO.playerList);
        poste.id = id;
        return posteRepository.save(poste);

    }
    public List<PosteDTO> getAll(){

        List<Poste> postes = posteRepository.findAll();

        return postes.stream().map(poste -> PosteDTO.get(poste.id, poste.name, poste.players)).collect(Collectors.toList());

    }


    public String delete(Integer id){
        Poste poste = posteRepository.findById(id).orElse(null);
        if(poste==null){
            return null;
        }
        posteRepository.deleteById(id);

        return "Deleted";
    }

}
