package com.projet.scootop.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.scootop.domain.user.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {

}
