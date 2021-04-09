package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.model.domainconfiguration.ClubDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.ClubRepository;
import com.projet.scootop.scootop.repository.domainconfiguration.TeamRepository;
import com.projet.scootop.scootop.repository.user.ContactRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
        contactRepository.save(clubDTO.getContact());
        teamRepository.saveAll(clubDTO.getTeams());
        Club newClub = this.mapTo(clubDTO);
        return clubRepository.save(newClub);

    }
    public Club update(ClubDTO clubDTO,Integer id) throws Exception {
        teamRepository.saveAll(clubDTO.getTeams());
        contactRepository.save(clubDTO.getContact());
        Club club = this.mapTo(clubDTO);
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
        return this.mapTo(club);
    }

    public List<ClubDTO> getAll(){
        List<Club> clubs = clubRepository.findAll();
        return this.mapTo(clubs);
    }

    public String delete(Long id){
        Club scoot = clubRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        clubRepository.deleteById(id);

        return "Deleted";
    }
    
    public Club mapTo(ClubDTO cDTO) {
		Assert.notNull(cDTO, "The club must not be null");
		Club c = new Club();
        BeanUtils.copyProperties(cDTO, c);
        return c;
    }
	
    public ClubDTO mapTo(Club c) {
        Assert.notNull(c, "The club must not be null");
        ClubDTO cDTO = new ClubDTO();
        BeanUtils.copyProperties(c, cDTO);
        return cDTO;
    }

    public List<ClubDTO> mapTo(List<Club> post) {
        Assert.notNull(post, "The clubList must not be null");
        return post.stream().map(Club -> this.mapTo(Club)).collect(Collectors.toList());
    }

}