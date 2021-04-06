package com.projet.scootop.scootop.repository.user;

import com.projet.scootop.scootop.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
