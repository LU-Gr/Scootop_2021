package com.projet.scootop.repository.user.domainuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.user.domainuser.Chairman;

@Repository
public interface ChairmanRepository extends JpaRepository<Chairman,Long> {

}
