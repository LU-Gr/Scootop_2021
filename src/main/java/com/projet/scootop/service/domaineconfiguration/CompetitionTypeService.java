package com.projet.scootop.service.domaineconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.repository.domainconfiguration.CompetitionTypeRepository;

@Service
public class CompetitionTypeService {
    @Autowired
    public CompetitionTypeRepository typeRepository;

}
