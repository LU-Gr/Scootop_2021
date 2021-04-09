package com.projet.scootop.scootop.model.domainuser;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CoachDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private User user;

	@Getter
    private List<Team> teams;

    @Override
    public String toString() {
        return "CoachDTO{" +
                "id=" + id +
                ", user=" + user +
                ", teams=" + teams +
                '}';
    }
}
