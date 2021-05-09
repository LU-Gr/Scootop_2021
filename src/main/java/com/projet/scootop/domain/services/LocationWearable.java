package com.projet.scootop.domain.services;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.projet.scootop.domain.tools.Match;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.domainuser.Player;

import lombok.Getter;
import lombok.Setter;

@Entity
public class LocationWearable {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    
	@ManyToOne
    @JoinColumn
    @Getter @Setter
    private Player player;

    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Team team;
    
    @ManyToOne
    @JoinColumn
    @Getter @Setter
    private Match match;
    
    @Getter @Setter
    private Integer distanceRun;
    
    @Getter @Setter
    private Integer distancePlay;
    
    @Getter @Setter
    private Integer vMax;
    
    @Getter @Setter
    private Integer vMaxWithBall;
    
    @Getter @Setter
    private Integer ballPlay;
    
    @Getter @Setter
    private Integer looseBall;
    
    @Getter @Setter
    private Integer ballRecovered;
    
    @Getter @Setter
    private Integer tackle;
    
    @Getter @Setter
    private Integer foulSuffered;
    
    @Getter @Setter
    private Integer failPass;
    
    @Getter @Setter
    private Integer assist;
    
    @Getter @Setter
    private Integer shortPass;
    
    @Getter @Setter
    private Integer head;
    
    @Getter @Setter
    private Integer headOffensive;
    
    @Getter @Setter
    private Integer headDefensive;
    
    @Getter @Setter
    private Integer shots;
    
    @Getter @Setter
    private Integer shotOnTarget;
    
    @Getter @Setter
    private Integer shotOffTarget;
    
    @Getter @Setter
    private Integer longShot;
    
    @Getter @Setter
    private Integer successSkill;
    
    @Getter @Setter
    private Integer failSkill;
    
    public LocationWearable() {
    	
    }
}
