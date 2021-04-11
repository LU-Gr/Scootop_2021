package com.projet.scootop.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.scootop.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
