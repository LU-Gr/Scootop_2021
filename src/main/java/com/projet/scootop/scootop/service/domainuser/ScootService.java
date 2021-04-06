package com.projet.scootop.scootop.service.domainuser;

import com.projet.scootop.scootop.domain.domainconfiguration.Club;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.domain.user.User;
import com.projet.scootop.scootop.model.domainuser.ScootDTO;
import com.projet.scootop.scootop.repository.domainuser.ScootRepository;
import com.projet.scootop.scootop.service.domaineconfiguration.ClubService;
import com.projet.scootop.scootop.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScootService {
  @Autowired
  public ScootRepository scootRepository;
  public UserService userService;
  public ClubService clubService;
  public Scoot add(ScootDTO scootDTO) throws Exception {
    userService.updateEntity(scootDTO.user);
    for (Club club: scootDTO.clubs
         ) {
      clubService.updateEntity(club);
    }
    Scoot scoot=new Scoot(scootDTO.user,scootDTO.clubs, scootDTO.shortlist);
   
    return  scootRepository.save(scoot);
  }
  public ScootDTO get(Long id){

    Scoot scoot = scootRepository.findById(id).orElse(null);

    if(scoot==null){
      return null;
    }

    return ScootDTO.get(scoot.id,scoot.user, scoot.clubs, scoot.shortlist);

  }
  public List<Scoot> getAll(){
    return scootRepository.findAll();

  }

  public List<ScootDTO> getAllByMatcSheetId(Long matchSheet){

    List<Scoot> scoots = scootRepository.findAllById(matchSheet);
    return scoots.stream().map(scoot -> ScootDTO.get(scoot.id,scoot.user, scoot.clubs, scoot.shortlist)).collect(Collectors.toList());

  }

  public Scoot update(ScootDTO scootDTO,Long id) throws Exception {
    User newUser = userService.updateEntity(scootDTO.user);
    Scoot scoot=new Scoot(newUser,scootDTO.clubs, scootDTO.shortlist);
    scoot.id=id;

    return scootRepository.save(scoot);

  }

  public String delete(Long id){
    Scoot scoot = scootRepository.findById(id).orElse(null);
    if(scoot==null){
      return null;
    }
    //System.out.println(stade.contact.toString());
    //contactRepository.delete(stade.contact);

    scootRepository.deleteById(id);

    return "Deleted";
  }

}
