package com.projet.scootop.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.configuration.Category;
import com.projet.scootop.mappers.configuration.CategoryMapper;
import com.projet.scootop.model.configuration.CategoryDTO;
import com.projet.scootop.repository.configuration.CategoryRepository;
import com.projet.scootop.repository.configuration.CategoryTypeRepository;

import java.util.List;

@Service
public class CategoryService {
	
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private CategoryTypeRepository categoryTypeRepository;
    @Autowired private CategoryMapper categoryMapper;

    public CategoryDTO add(CategoryDTO categoryDTO){
        Category category = categoryMapper.mapTo(categoryDTO);
        categoryTypeRepository.save(category.getCategoryType());
        categoryRepository.save(category);
        return categoryMapper.mapToDTO(category);
    }
    
    public CategoryDTO get(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category==null){
            return null;
        }
        return categoryMapper.mapToDTO(category);
    }

    public CategoryDTO update(CategoryDTO categoryDTO){
        
        Category category = categoryMapper.mapTo(categoryDTO);
        categoryTypeRepository.save(category.getCategoryType());
        categoryRepository.save(category);
        return categoryMapper.mapToDTO(category);   
    }
    
    public CategoryDTO updateEntity(Category category){
        categoryTypeRepository.save(category.getCategoryType());
        categoryRepository.save(category);
        return categoryMapper.mapToDTO(category);
    }

    public List<CategoryDTO> getAll(){
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.mapToDTO(categories);
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
