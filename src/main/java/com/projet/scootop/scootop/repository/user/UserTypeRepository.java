package com.projet.scootop.scootop.repository.user;

import com.projet.scootop.scootop.servicetools.AgenceType;
import com.projet.scootop.scootop.user.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;


public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}
