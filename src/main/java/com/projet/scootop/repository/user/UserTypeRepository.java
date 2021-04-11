package com.projet.scootop.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.scootop.domain.user.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
