package com.projet.scootop.scootop.repository.domainuser;

import com.projet.scootop.scootop.domain.domainuser.Scoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScootRepository extends JpaRepository<Scoot,Long> {

    //TODO: ???
    List<Scoot> findAllById(Long Sheet);
}
