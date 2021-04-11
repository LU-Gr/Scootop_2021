package com.projet.scootop.service.domaintools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domaintools.CategoryType;
import com.projet.scootop.model.domaintools.CategoryTypeDTO;
import com.projet.scootop.repository.domainetools.CategoryTypeRepository;

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
