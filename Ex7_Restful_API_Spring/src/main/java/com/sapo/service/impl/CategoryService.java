package com.sapo.service.impl;

import com.sapo.converter.CategoryConverter;
import com.sapo.converter.NewConverter;
import com.sapo.dto.CategoryDTO;
import com.sapo.dto.NewDTO;
import com.sapo.entity.CategoryEntity;
import com.sapo.entity.NewEntity;
import com.sapo.repository.CategoryRepository;
import com.sapo.repository.NewRepository;
import com.sapo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Autowired
    private NewConverter newConverter;


    @Override
    public void deleteCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findOneById(id);
        List<NewEntity> newEntities = newRepository.findByCategory(categoryEntity);

        for(NewEntity newEntity : newEntities){
            newRepository.delete(newEntity.getId());
        }
        categoryRepository.delete(id);
    }

    @Override
    public CategoryDTO save(CategoryDTO model) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if(model.getId() != null){
            CategoryEntity oldCategory = categoryRepository.findOneById(model.getId());
            categoryEntity = categoryConverter.toEntity(model, oldCategory);
        }else {
            categoryEntity = categoryConverter.toEntity(model);
        }

        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryConverter.toDTO(categoryEntity);
    }

    @Override
    public List<CategoryDTO> getCategory(String code) {
        List<CategoryEntity> categoryEntities = new ArrayList<CategoryEntity>();
        categoryEntities = categoryRepository.findByCodeContaining(code);
        List<CategoryDTO> categoryDTOS = new ArrayList<CategoryDTO>();
        for(CategoryEntity entity : categoryEntities ){
            categoryDTOS.add(categoryConverter.toDTO(entity));
        }
        return categoryDTOS;
    }

    @Override
    public List<CategoryDTO> getCategory() {
        List<CategoryEntity> categoryEntities = new ArrayList<CategoryEntity>();
        categoryEntities = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<CategoryDTO>();
        for(CategoryEntity entity : categoryEntities ){
            categoryDTOS.add(categoryConverter.toDTO(entity));
        }
        return categoryDTOS;
    }

    @Override
    public CategoryDTO getNewByCategory(Long id) {
        CategoryEntity categoryEntity;
        categoryEntity = categoryRepository.findOne(id);
        CategoryDTO categoryDTO = categoryConverter.toDTO(categoryEntity);
        List<NewEntity> newEntities = new ArrayList<NewEntity>();
        newEntities = newRepository.findByCategory(categoryEntity);
        List<NewDTO> newDTOS = new ArrayList<NewDTO>();
        for(NewEntity entity : newEntities){
            newDTOS.add(newConverter.toDTO(entity));
        }
        categoryDTO.setListResult(newDTOS);
        return categoryDTO;
    }
}
