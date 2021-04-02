package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.domain.services.Wearable;
import com.projet.scootop.scootop.model.ClubDTO;
import com.projet.scootop.scootop.model.ContactDTO;
import com.projet.scootop.scootop.model.domainconfiguration.TeamDTO;
import com.projet.scootop.scootop.model.services.WearableDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.ClubRepository;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.user.ContactRepository;
import com.projet.scootop.scootop.user.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ContactRepository contactRepository;

    public Club addClub(ClubDTO clubDTO) throws Exception {
        contactRepository.save(clubDTO.contact);
        teamRepository.saveAll(clubDTO.teams);
        Club newClub = new Club(clubDTO.name, clubDTO.contact, clubDTO.colorInside, clubDTO.colorOutSide, clubDTO.teams, clubDTO.scoot);
        return clubRepository.save(newClub);

    }
    public Club update(ClubDTO clubDTO,Integer id) throws Exception {
        teamRepository.saveAll(clubDTO.teams);
        Contact contact=contactRepository.save(clubDTO.contact);
        Club club = new Club(clubDTO.name, contact, clubDTO.colorInside, clubDTO.colorOutSide, clubDTO.teams,clubDTO.scoot);
        club.id=id;
        return clubRepository.save(club);
    }
    public Club updateEntity(Club club){
        contactRepository.save(club.contact);
        teamRepository.saveAll(club.teams);

        return clubRepository.save(club);
    }
    public ClubDTO get(Integer id){

        Club club = clubRepository.findById(id).orElse(null);
        if(club==null){
            return null;
        }

        return ClubDTO.get(club.id, club.name, club.contact, club.colorInside, club.colorOutSide,club.teams, club.scoots);
    }

    public List<ClubDTO> getAll(){
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> ClubDTO.get(club.id, club.name, club.contact, club.colorInside, club.colorOutSide,club.teams, club.scoots)).collect(Collectors.toList());
    }

    public String delete(Integer id){
        Club scoot = clubRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        clubRepository.deleteById(id);

        return "Deleted";
    }

}