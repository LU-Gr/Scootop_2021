package com.projet.scootop.mappers.domainuser;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domainuser.Player;
import com.projet.scootop.model.domainuser.PlayerDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PlayerMapper {
	
	public Player mapTo(PlayerDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Player entity = new Player();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public PlayerDTO mapTo(Player entity) {
        Assert.notNull(entity, "The entity must not be null");
        PlayerDTO dto = new PlayerDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<PlayerDTO> mapTo(List<Player> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
