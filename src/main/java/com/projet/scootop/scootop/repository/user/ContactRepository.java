package com.projet.scootop.scootop.repository.user;

import com.projet.scootop.scootop.user.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
