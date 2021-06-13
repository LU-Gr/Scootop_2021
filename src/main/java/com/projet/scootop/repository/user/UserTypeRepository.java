package com.projet.scootop.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.user.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

	public UserType findByType(String type);
}
