package com.projet.scootop.repository.user.domainuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.user.domainuser.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach,Long> {

}
