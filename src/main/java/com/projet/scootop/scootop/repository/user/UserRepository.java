package com.projet.scootop.scootop.repository.user;

import com.projet.scootop.scootop.servicetools.AgenceType;
import com.projet.scootop.scootop.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;


public interface UserRepository extends JpaRepository<User, Integer> {

}
