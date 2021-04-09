package com.projet.scootop.scootop.model.domainuser;

import com.projet.scootop.scootop.domain.user.User;

import lombok.Getter;
import lombok.Setter;

public class ChairmanDTO {

	@Getter @Setter
    private Long id;
	
	@Getter @Setter
    private User user;

    public static ChairmanDTO create( User user) {
        ChairmanDTO chairmanDTO = new ChairmanDTO();
        chairmanDTO.user = user;
        return chairmanDTO;
    }
    public static ChairmanDTO get(Long id, User user) {
        ChairmanDTO chairmanDTO = new ChairmanDTO();
        chairmanDTO.id = id;
        chairmanDTO.user = user;
        return chairmanDTO;
    }

    @Override
    public String toString() {
        return "ChairmanDTO{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
