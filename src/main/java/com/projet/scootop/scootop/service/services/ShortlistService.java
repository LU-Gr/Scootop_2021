package com.projet.scootop.scootop.service.services;

import com.projet.scootop.scootop.domain.services.Shortlist;
import com.projet.scootop.scootop.model.services.ShortlistDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.scootop.repository.domainuser.ScootRepository;
import com.projet.scootop.scootop.repository.services.ShortlistRepository;
import com.projet.scootop.scootop.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ShortlistService {

    @Autowired
    private ShortlistRepository shortlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ScootRepository scootRepository;

    @Autowired
    private TeamRepository teamRepository;

    public ShortlistDTO addShortlist(ShortlistDTO shortlistDTO) {

        userRepository.save(shortlistDTO.user);
        playerRepository.saveAll(shortlistDTO.Players);
        scootRepository.saveAll(shortlistDTO.Scoots);
        teamRepository.saveAll(shortlistDTO.Teams);


        Shortlist shortlist = new Shortlist(shortlistDTO.user, shortlistDTO.Players, shortlistDTO.Scoots, shortlistDTO.Teams, shortlistDTO.rank);
        shortlistRepository.save(shortlist);

        return shortlistDTO;
    }
    public ShortlistDTO get(Integer id){

        Shortlist shortlist = shortlistRepository.findById(id).orElse(null);
        if(shortlist==null){
            return null;
        }

        return ShortlistDTO.get(shortlist.id, shortlist.user, shortlist.Players, shortlist.Scoots, shortlist.Teams, shortlist.rank);
    }

    public List<ShortlistDTO> getAll(){

        List<Shortlist> shortlists = shortlistRepository.findAll();
        return shortlists.stream().map(shortlist -> ShortlistDTO.get(shortlist.id, shortlist.user, shortlist.Players, shortlist.Scoots, shortlist.Teams, shortlist.rank)).collect(Collectors.toList());
    }


    public String delete(Integer id){
        Shortlist shortlist = shortlistRepository.findById(id).orElse(null);
        if(shortlist==null){
            return null;
        }
        shortlistRepository.deleteById(id);

        return "Deleted";
    }
}
