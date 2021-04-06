package com.projet.scootop.scootop.repository.domainuser;

import com.projet.scootop.scootop.domain.domainuser.Chairman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairmanRepository extends JpaRepository<Chairman,Long> {

}
