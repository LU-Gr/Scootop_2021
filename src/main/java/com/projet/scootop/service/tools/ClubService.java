package com.projet.scootop.service.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.tools.Club;
import com.projet.scootop.mappers.tools.ClubMapper;
import com.projet.scootop.model.tools.ClubDTO;
import com.projet.scootop.repository.tools.ClubRepository;
import com.projet.scootop.repository.tools.TeamRepository;
import com.projet.scootop.repository.user.ContactRepository;

import java.util.List;

@Service
public class ClubService {
	
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private ClubMapper clubMapper;

    public Club addClub(ClubDTO clubDTO) throws Exception {
        contactRepository.save(clubDTO.getContact());
        teamRepository.saveAll(clubDTO.getTeams());
        Club newClub = clubMapper.mapTo(clubDTO);
        return clubRepository.save(newClub);

    }
    public Club update(ClubDTO clubDTO,Integer id) throws Exception {
        teamRepository.saveAll(clubDTO.getTeams());
        contactRepository.save(clubDTO.getContact());
        Club club = clubMapper.mapTo(clubDTO);
        club.setId(id);
        return clubRepository.save(club);
    }
    
    //TODO: Delete probablement, lors de la création d'un scoot on ne met pas le club
    public Club updateEntity(Club club){
        contactRepository.save(club.getContact());
        teamRepository.saveAll(club.getTeams());
        return clubRepository.save(club);
    }
    
    public ClubDTO get(Long id){
        Club club = clubRepository.findById(id).orElse(null);
        if(club==null){
            return null;
        }
        return clubMapper.mapTo(club);
    }

    public List<ClubDTO> getAll(){
        List<Club> clubs = clubRepository.findAll();
        return clubMapper.mapTo(clubs);
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