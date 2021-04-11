package com.projet.scootop.service.domaineconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainconfiguration.Poste;
import com.projet.scootop.model.domainconfiguration.PosteDTO;
import com.projet.scootop.repository.domainconfiguration.PosteRepository;

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
    public PosteDTO get(Long id) {

        Poste poste = posteRepository.findById(id).orElse(null);
        if(poste==null){
            return null;
        }
        return PosteDTO.get(poste.getId(), poste.getName(),poste.getPlayers());

    }
    public Poste update(PosteDTO posteDTO, Long id) {

        Poste poste=new Poste(posteDTO.name,posteDTO.playerList);
        poste.setId(id);
        return posteRepository.save(poste);

    }
    public List<PosteDTO> getAll(){

        List<Poste> postes = posteRepository.findAll();

        return postes.stream().map(poste -> PosteDTO.get(poste.getId(), poste.getName(), poste.getPlayers())).collect(Collectors.toList());

    }


    public String delete(Long id){
        Poste poste = posteRepository.findById(id).orElse(null);
        if(poste==null){
            return null;
        }
        posteRepository.deleteById(id);

        return "Deleted";
    }

}
