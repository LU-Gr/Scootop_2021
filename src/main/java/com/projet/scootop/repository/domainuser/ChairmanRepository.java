package com.projet.scootop.repository.domainuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.domainuser.Chairman;

@Repository
public interface ChairmanRepository extends JpaRepository<Chairman,Long> {

}
