package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.repository.domainconfiguration.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;

@Service
public class TypeService {
    @Autowired
    public TypeRepository typeRepository;

}
