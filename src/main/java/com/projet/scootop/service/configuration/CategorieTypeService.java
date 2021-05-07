package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.CategoryType;
import com.projet.scootop.model.configuration.CategoryTypeDTO;
import com.projet.scootop.repository.configuration.CategoryTypeRepository;

import java.util.List;


@Service
public class CategorieTypeService {

    @Autowired
    public CategoryTypeRepository categoryTypeRepository;

    public CategoryType add(CategoryTypeDTO categorieDTO){
        CategoryType categorieType = new CategoryType(categorieDTO.getDateAgeMax());
        return categoryTypeRepository.save(categorieType);

    }
    public CategoryType update(CategoryTypeDTO categorieDTO){
        CategoryType categorieType = new CategoryType(categorieDTO.getDateAgeMax());
        return categoryTypeRepository.save(categorieType);

    }
    public CategoryType get(Long id){
        return categoryTypeRepository.findById(id).orElse(null);

    }
    public List<CategoryType> getAll(){
        return categoryTypeRepository.findAll();
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
