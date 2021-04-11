package com.projet.scootop.repository.provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.provider.Cameraman;

@Repository
public interface CameramanRepository extends JpaRepository<Cameraman, Long> {

}
