package com.projet.scootop.scootop.service.domaintools;

import com.projet.scootop.scootop.domain.domaintools.CategoryType;
import com.projet.scootop.scootop.model.domainetools.CategoryTypeDTO;
import com.projet.scootop.scootop.repository.domainetools.CategoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategorieTypeService {

    @Autowired
    public CategoryTypeRepository categoryTypeRepository;

    public CategoryType add(CategoryTypeDTO categorieDTO){
        CategoryType categorieType = new CategoryType(categorieDTO.name,categorieDTO.dateAgeMax);
        return categoryTypeRepository.save(categorieType);

    }
    public CategoryType update(CategoryTypeDTO categorieDTO, Long id){
        CategoryType categorieType = new CategoryType(categorieDTO.name,categorieDTO.dateAgeMax);
        categorieType.id=id;
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
