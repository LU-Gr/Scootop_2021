package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.domain.services.Wearable;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.services.WearableDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.CategoryRepository;
import com.projet.scootop.scootop.repository.domainetools.CategoryTypeRepository;
import com.projet.scootop.scootop.repository.domainetools.CompetitionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public CompetitionTypeRepository competionTypeRepository;
    @Autowired
    public CategoryTypeRepository categoryTypeRepository;

    public Category add(CategoryDTO categoryDTO){

        competionTypeRepository.saveAll(categoryDTO.competionType);
        categoryTypeRepository.save(categoryDTO.categoryType);
        Category category=new Category(categoryDTO.name,categoryDTO.competionType,categoryDTO.categoryType);
        return categoryRepository.save(category);

    }
    public CategoryDTO get(Integer id){

        Category category = categoryRepository.findById(id).orElse(null);
        if(category==null){
            return null;
        }
        return CategoryDTO.get(category.id, category.name, category.competitionTypes,category.categoryType);
    }

    public Category update(CategoryDTO categoryDTO,Integer id){

        competionTypeRepository.saveAll(categoryDTO.competionType);
        categoryTypeRepository.save(categoryDTO.categoryType);
        Category category=new Category(categoryDTO.name,categoryDTO.competionType,categoryDTO.categoryType);
        category.id=id;
        return categoryRepository.save(category);
    }

    public Category updateEntity(Category category){

        competionTypeRepository.saveAll(category.competitionTypes);
        categoryTypeRepository.save(category.categoryType);
        return categoryRepository.save(category);
    }

    public List<CategoryDTO> getAll(){

        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(category -> CategoryDTO.get(category.id, category.name, category.competitionTypes, category.categoryType)).collect(Collectors.toList());

    }

    public String delete(Integer id){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category==null){
            return null;
        }
        categoryRepository.deleteById(id);

        return "Deleted";
    }




}
