package com.projet.scootop.model.tools;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.Contact;
import com.projet.scootop.domain.user.domainuser.Scoot;

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
