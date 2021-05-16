package com.projet.scootop.service.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.CategoryType;
import com.projet.scootop.mappers.configuration.CategoryTypeMapper;
import com.projet.scootop.model.configuration.CategoryTypeDTO;
import com.projet.scootop.repository.configuration.CategoryTypeRepository;


@Service
public class CategoryTypeService {

    @Autowired private CategoryTypeRepository categoryTypeRepository;
    @Autowired private CategoryTypeMapper mapper;

    public CategoryTypeDTO add(CategoryTypeDTO categorieDTO){
        CategoryType categorieType = mapper.mapTo(categorieDTO);
        categoryTypeRepository.save(categorieType);
        return mapper.mapToDTO(categorieType);

    }
    
    public CategoryTypeDTO update(CategoryTypeDTO categorieDTO){
    	CategoryType categorieType = mapper.mapTo(categorieDTO);
        categoryTypeRepository.save(categorieType);
        return mapper.mapToDTO(categorieType);

    }
    public CategoryTypeDTO get(Long id){
    	CategoryType ct = categoryTypeRepository.findById(id).orElse(null);
        return mapper.mapToDTO(ct);

    }
    public List<CategoryTypeDTO> getAll(){
    	List<CategoryType> cts = categoryTypeRepository.findAll();
        return mapper.mapToDTO(cts);
    }
    public String delete(Long id){
        CategoryType categorie = categoryTypeRepository.findById(id).orElse(null);
        if(categorie==null){
            return null;
        }
        categoryTypeRepository.deleteById(id);

        return "Deleted";
    }

}
