package com.projet.scootop.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.Contact;
import com.projet.scootop.mappers.user.ContactMapper;
import com.projet.scootop.model.user.ContactDTO;
import com.projet.scootop.repository.user.ContactRepository;

import java.util.List;

@Service
public class ContactService {
	
    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private ContactMapper mapper;

    public ContactDTO addContact(ContactDTO contactDTO) {
        Contact contact = mapper.mapTo(contactDTO);
        contactRepository.save(contact);
        return contactDTO;
    }
    
    public ContactDTO get(Long id){
        Contact contact = contactRepository.findById(id).orElse(null);
        if(contact==null){
            return null;
        }
        return mapper.mapToDTO(contact);
    }

    public List<ContactDTO> getAll(){
        List<Contact> contacts = contactRepository.findAll();
        return mapper.mapToDTO(contacts);
    }


    public String delete(Long id){
        Contact scoot = contactRepository.findById(id).orElse(null);
        if(scoot==null){
            return null;
        }
        contactRepository.deleteById(id);
        return "Deleted";
    }
}
