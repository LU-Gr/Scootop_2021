package com.projet.scootop.scootop.service.domaineconfiguration;

import com.projet.scootop.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.scootop.mappers.domainconfiguration.CategoryMapper;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.repository.domainconfiguration.CategoryRepository;
import com.projet.scootop.scootop.repository.domainetools.CategoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public CategoryTypeRepository categoryTypeRepository;
    
    @Autowired
    private CategoryMapper categoryMapper;

    public Category add(CategoryDTO categoryDTO){
        categoryTypeRepository.save(categoryDTO.getCategoryType());
        Category category = categoryMapper.mapTo(categoryDTO);
        return categoryRepository.save(category);

    }
    
    public CategoryDTO get(Long id){
        Category category = categoryRepository.findById(id).orElse(null);
        if(category==null){
            return null;
        }
        return categoryMapper.mapTo(category);
    }

    public Category update(CategoryDTO categoryDTO,Integer id){
        categoryTypeRepository.save(categoryDTO.getCategoryType());
        Category category = categoryMapper.mapTo(categoryDTO);
        category.setId(id);
        return categoryRepository.save(category);
    }

    public Category updateEntity(Category category){
        categoryTypeRepository.save(category.getCategoryType());
        return categoryRepository.save(category);
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
