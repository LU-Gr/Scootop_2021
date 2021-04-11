package com.projet.scootop.service.stastistical.physical;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.repository.statistical.physical.PlayerHeadRepository;

@Service
public class PlayerHeadService {
    @Autowired
    public PlayerHeadRepository playerHeadRepository;
}
