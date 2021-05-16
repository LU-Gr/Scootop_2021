package com.projet.scootop.repository.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.user.domain.Chairman;

@Repository
public interface ChairmanRepository extends JpaRepository<Chairman,Long> {

}
