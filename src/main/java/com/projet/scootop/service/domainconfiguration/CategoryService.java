package com.projet.scootop.service.domainconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.mappers.domainconfiguration.CategoryMapper;
import com.projet.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.repository.domainconfiguration.CategoryRepository;
import com.projet.scootop.repository.domainetools.CategoryTypeRepository;

import java.util.List;

@Service
public class CategoryService {
	
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public CategoryTypeRepository categoryTypeRepository;
    
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDTO add(CategoryDTO categoryDTO){
        categoryTypeRepository.save(categoryDTO.getCategoryType());
        Category category = categoryMapper.mapTo(categoryDTO);
        categoryRepository.save(category);
        return categoryMapper.mapTo(category);
    }
    
    public CategoryDTO get(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category==null){
            return null;
        }
        return categoryMapper.mapTo(category);
    }

    public CategoryDTO update(CategoryDTO categoryDTO,Integer id){
        categoryTypeRepository.save(categoryDTO.getCategoryType());
        Category category = categoryMapper.mapTo(categoryDTO);
        category.setId(id);
        categoryRepository.save(category);
        return categoryMapper.mapTo(category);   
    }
    public CategoryDTO updateEntity(Category category){
        categoryTypeRepository.save(category.getCategoryType());
        categoryRepository.save(category);
        return categoryMapper.mapTo(category);
    }

    public List<CategoryDTO> getAll(){
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.mapTo(categories);
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