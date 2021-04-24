package com.projet.scootop.mappers.domaintools;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.projet.scootop.domain.domaintools.SkillType;
import com.projet.scootop.model.domaintools.SkillTypeDTO;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class SkillTypeMapper {
	
	public SkillType mapTo(SkillTypeDTO dto) {
		Assert.notNull(dto, "The entity must not be null");
		SkillType entity = new SkillType();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
	
    public SkillTypeDTO mapTo(SkillType entity) {
        Assert.notNull(entity, "The entity must not be null");
        SkillTypeDTO dto = new SkillTypeDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public List<SkillTypeDTO> mapTo(List<SkillType> entities) {
        Assert.notNull(entities, "entities must not be null");
        return entities.stream().map(entity -> this.mapTo(entity)).collect(Collectors.toList());
    }
}
