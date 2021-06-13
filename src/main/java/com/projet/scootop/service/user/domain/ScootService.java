package com.projet.scootop.service.user.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.Shortlist;
import com.projet.scootop.domain.user.User;
import com.projet.scootop.domain.user.domain.Scoot;
import com.projet.scootop.mappers.user.domain.ScootMapper;
import com.projet.scootop.model.user.domain.ScootDTO;
import com.projet.scootop.repository.services.ShortlistRepository;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.domain.ScootRepository;
import com.projet.scootop.service.user.UserTypeService;

import java.util.List;

@Service
public class ScootService {
	
  @Autowired private ScootRepository scootRepository;
  @Autowired private UserRepository userRepository;
  @Autowired private ShortlistRepository shortlistRepository;
  @Autowired private UserTypeService userTypeService;	
  @Autowired private ScootMapper mapper;
  
  public ScootDTO add(ScootDTO scootDTO){
	  Scoot scoot = mapper.mapTo(scootDTO);
	  scoot.setShortlist(new Shortlist(scoot.getUser()));
	  User user = userRepository.getOne(scoot.getUser().getId());
	  user.getUserTypes().add(userTypeService.getOneByType("Scoot"));
	  shortlistRepository.save(scoot.getShortlist());
	  userRepository.save(user);
	  scootRepository.save(scoot);
	  return mapper.mapToDTO(scoot);
  }
  
  public ScootDTO get(Long id){
    Scoot scoot = scootRepository.findById(id).orElse(null);
    if(scoot==null){
      return null;
    }
    return mapper.mapToDTO(scoot);
  }
  
  public List<ScootDTO> getAll(){
	  List<Scoot> scoots = scootRepository.findAll();
	  return mapper.mapToDTO(scoots);
  }

  
  public List<ScootDTO> getAllByMatchSheetId(Long matchSheetId){
    List<Scoot> scoots = scootRepository.findAllById(matchSheetId);
    return mapper.mapToDTO(scoots);
  }

  public ScootDTO update(ScootDTO scootDTO){
	  Scoot scoot = mapper.mapTo(scootDTO);
	  scootRepository.save(scoot);
	  return mapper.mapToDTO(scoot);
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
