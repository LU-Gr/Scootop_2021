package com.projet.scootop.service.user.domainuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.domainuser.Scoot;
import com.projet.scootop.mappers.user.domainuser.ScootMapper;
import com.projet.scootop.model.user.domainuser.ScootDTO;
import com.projet.scootop.repository.user.UserRepository;
import com.projet.scootop.repository.user.domainuser.ScootRepository;

import java.util.List;

@Service
public class ScootService {
	
  @Autowired
  private ScootRepository scootRepository;
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private ScootMapper mapper;
  
  public ScootDTO add(ScootDTO scootDTO) throws Exception {
	  Scoot scoot = mapper.mapTo(scootDTO);
	  userRepository.save(scoot.getUser());
	  scootRepository.save(scoot);
	  return mapper.mapTo(scoot);
  }
  
  public ScootDTO get(Long id){
    Scoot scoot = scootRepository.findById(id).orElse(null);
    if(scoot==null){
      return null;
    }
    return mapper.mapTo(scoot);
  }
  
  public List<ScootDTO> getAll(){
	  List<Scoot> scoots = scootRepository.findAll();
	  return mapper.mapTo(scoots);
  }

  
  public List<ScootDTO> getAllByMatchSheetId(Long matchSheetId){
    List<Scoot> scoots = scootRepository.findAllById(matchSheetId);
    return mapper.mapTo(scoots);
  }

  public ScootDTO update(ScootDTO scootDTO,Long id) throws Exception {
	  Scoot scoot = mapper.mapTo(scootDTO);
	  scootRepository.save(scoot);
	  return mapper.mapTo(scoot);
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
