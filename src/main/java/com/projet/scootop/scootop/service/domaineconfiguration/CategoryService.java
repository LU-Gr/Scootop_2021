package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.CategoryRepository;
import com.projet.scootop.scootop.repository.domainetools.CategoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public CategoryTypeRepository categoryTypeRepository;

    public Category add(CategoryDTO categoryDTO){

        categoryTypeRepository.save(categoryDTO.categoryType);
        Category category=new Category(categoryDTO.name,categoryDTO.categoryType);
        return categoryRepository.save(category);

    }
    public CategoryDTO get(Long id){

        Category category = categoryRepository.findById(id).orElse(null);
        if(category==null){
            return null;
        }
        return CategoryDTO.get(category.id, category.name,category.categoryType);
    }

    public Category update(CategoryDTO categoryDTO,Integer id){

        categoryTypeRepository.save(categoryDTO.categoryType);
        Category category=new Category(categoryDTO.name,categoryDTO.categoryType);
        category.id=id;
        return categoryRepository.save(category);
    }

    public Category updateEntity(Category category){

        categoryTypeRepository.save(category.categoryType);
        return categoryRepository.save(category);
    }

    public List<CategoryDTO> getAll(){

        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(category -> CategoryDTO.get(category.id, category.name, category.categoryType)).collect(Collectors.toList());

    }

    public String delete(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category==null){
            return null;
        }
        categoryRepository.deleteById(id);

        return "Deleted";
    }




}
