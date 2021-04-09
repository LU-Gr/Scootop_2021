package com.projet.scootop.scootop.mappers.domaintools;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import com.projet.scootop.scootop.domain.domaintools.Skill;
import com.projet.scootop.scootop.model.domaintools.SkillDTO;
import java.util.List;
import java.util.stream.Collectors;

public class SkillMapper {
	
	public Skill mapTo(SkillDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		Skill entity = new Skill();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public SkillDTO mapTo(Skill entity) {
        Assert.notNull(entity, "The entity must not be null");
        SkillDTO dto = new SkillDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<SkillDTO> mapTo(List<Skill> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
