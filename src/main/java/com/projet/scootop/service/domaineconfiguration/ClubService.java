package com.projet.scootop.service.domaineconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.mappers.domainconfiguration.ClubMapper;
import com.projet.scootop.model.domainconfiguration.ClubDTO;
import com.projet.scootop.repository.domainconfiguration.ClubRepository;
import com.projet.scootop.repository.domainconfiguration.TeamRepository;
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