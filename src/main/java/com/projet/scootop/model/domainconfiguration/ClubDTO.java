package com.projet.scootop.model.domainconfiguration;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.domainuser.Scoot;
import com.projet.scootop.domain.user.Contact;

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
