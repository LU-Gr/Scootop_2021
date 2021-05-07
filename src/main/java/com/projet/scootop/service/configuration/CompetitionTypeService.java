package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.repository.configuration.CompetitionTypeRepository;

@Service
public class CompetitionTypeService {
    @Autowired
    public CompetitionTypeRepository typeRepository;

}
