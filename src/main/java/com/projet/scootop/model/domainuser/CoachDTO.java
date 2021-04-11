package com.projet.scootop.model.domainuser;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.user.User;

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
