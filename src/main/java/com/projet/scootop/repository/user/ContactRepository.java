package com.projet.scootop.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.user.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
