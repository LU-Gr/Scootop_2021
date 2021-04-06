package com.projet.scootop.scootop.repository.domainuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projet.scootop.scootop.domain.domainuser.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach,Long> {

}
