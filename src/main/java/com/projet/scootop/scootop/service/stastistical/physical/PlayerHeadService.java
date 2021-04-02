package com.projet.scootop.scootop.service.stastistical.physical;


import com.projet.scootop.scootop.repository.statistical.physical.PlayerHeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerHeadService {
    @Autowired
    public PlayerHeadRepository playerHeadRepository;
}
