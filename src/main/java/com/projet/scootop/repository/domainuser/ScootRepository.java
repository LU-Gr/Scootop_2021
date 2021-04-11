package com.projet.scootop.repository.domainuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.domainuser.Scoot;

import java.util.List;

@Repository
public interface ScootRepository extends JpaRepository<Scoot,Long> {

    //TODO: Renommer findAllByMatchSheetId
    List<Scoot> findAllById(Long Sheet);
}
