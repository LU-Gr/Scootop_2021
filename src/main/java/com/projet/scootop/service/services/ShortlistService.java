package com.projet.scootop.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.Shortlist;
import com.projet.scootop.mappers.services.ShortlistMapper;
import com.projet.scootop.model.services.ShortlistDTO;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.repository.domainuser.PlayerRepository;
import com.projet.scootop.repository.domainuser.ScootRepository;
import com.projet.scootop.repository.services.ShortlistRepository;
import com.projet.scootop.repository.user.UserRepository;

import java.util.List;


@Service
public class ShortlistService {

    @Autowired private ShortlistRepository shortlistRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private PlayerRepository playerRepository;
    @Autowired private ScootRepository scootRepository;
    @Autowired private TeamRepository teamRepository;
    @Autowired private ShortlistMapper mapper;

    public ShortlistDTO addShortlist(ShortlistDTO shortlistDTO) {
    	Shortlist shortlist = mapper.mapTo(shortlistDTO);
        userRepository.save(shortlist.getUser());
        playerRepository.saveAll(shortlist.getPlayers());
        scootRepository.saveAll(shortlist.getScoots());
        teamRepository.saveAll(shortlist.getTeams());
        shortlistRepository.save(shortlist);
        return mapper.mapTo(shortlist);
    }
    
    public ShortlistDTO get(Long id){

        Shortlist shortlist = shortlistRepository.findById(id).orElse(null);
        if(shortlist==null){
            return null;
        }

        return mapper.mapTo(shortlist);
    }

    public List<ShortlistDTO> getAll(){

        List<Shortlist> shortlists = shortlistRepository.findAll();
        return mapper.mapTo(shortlists);
    }


    public String delete(Long id){
        Shortlist shortlist = shortlistRepository.findById(id).orElse(null);
        if(shortlist==null){
            return null;
        }
        shortlistRepository.deleteById(id);

        return "Deleted";
    }
}
