package com.projet.scootop.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.user.Contact;
import com.projet.scootop.model.user.ContactDTO;
import com.projet.scootop.repository.user.ContactRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public ContactDTO addContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO.email,contactDTO.tel,contactDTO.address,contactDTO.cp);
        contactRepository.save(contact);
        return contactDTO;
    }
    public ContactDTO get(Long id){

        Contact contact = contactRepository.findById(id).orElse(null);
        if(contact==null){
            return null;
        }

        return ContactDTO.get(contact.id,contact.email,contact.tel,contact.address,contact.cp,contact.user);
    }

    public List<ContactDTO> getAll(){
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map(contact -> ContactDTO.get(contact.id,contact.email,contact.tel,contact.address,contact.cp,contact.user)).collect(Collectors.toList());
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
