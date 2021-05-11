package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Club;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.domainuser.Scoot;
import com.projet.scootop.mappers.tools.ClubMapper;
import com.projet.scootop.model.tools.ClubDTO;
import com.projet.scootop.repository.tools.ClubRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClubService {
	
    @Autowired private ClubRepository clubRepository;
    @Autowired private ClubMapper clubMapper;

    public ClubDTO add(ClubDTO clubDTO){
    	Club club = clubMapper.mapTo(clubDTO);
        clubRepository.save(club);
        return clubMapper.mapToDTO(club);

    }
    public ClubDTO update(ClubDTO clubDTO,Integer id){
    	Club club = clubMapper.mapTo(clubDTO);
        clubRepository.save(club);
        return clubMapper.mapToDTO(club); 
    }
    
    public ClubDTO get(Long id){
        Club club = clubRepository.findById(id).orElse(null);
        if(club==null){
            return null;
        }
        return clubMapper.mapToDTO(club);
    }

    public List<ClubDTO> getAll(){
        List<Club> clubs = clubRepository.findAll();
        return clubMapper.mapToDTO(clubs);
    }

    public String delete(Long id){
        Club scoot = clubRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        clubRepository.deleteById(id);

        return "Deleted";
    }
}