package com.projet.scootop.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
