package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.repository.domainconfiguration.CompetitionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionTypeService {
    @Autowired
    public CompetitionTypeRepository typeRepository;

}
