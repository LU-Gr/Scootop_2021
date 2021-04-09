package com.projet.scootop.scootop.model.domainconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Scoot;
import com.projet.scootop.scootop.domain.user.Contact;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ClubDTO {
	
	@Getter @Setter
    private String colorInside;
	
	@Getter @Setter
	private String colorOutSide;
	
	@Getter @Setter
	private Contact contact;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private Integer id;
	
	@Getter @Setter
	private List<Scoot> scoot;
	
	@Getter @Setter
	private List<Team> teams;

    @Override
    public String toString() {
        return "ClubDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
