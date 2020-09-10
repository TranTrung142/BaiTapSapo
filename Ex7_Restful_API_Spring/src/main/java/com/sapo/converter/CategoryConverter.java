package com.sapo.converter;

import com.sapo.dto.CategoryDTO;
import com.sapo.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    //converter categoryDTO => categoryEntity
    public CategoryEntity toEntity(CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCode(categoryDTO.getCode());
        categoryEntity.setName(categoryDTO.getName());
        return categoryEntity;
    }

    //converter categoryEntity => categoryDTO
    public CategoryDTO toDTO(CategoryEntity categoryEntity){
        CategoryDTO categoryDTO = new CategoryDTO();
        if(categoryEntity.getId() != null){
            categoryDTO.setId(categoryEntity.getId());
        }
        categoryDTO.setCode(categoryEntity.getCode());
        categoryDTO.setName(categoryEntity.getName());

        return categoryDTO;
    }
    //converter categoryDTO => oldCategory
    public CategoryEntity toEntity(CategoryDTO categoryDTO, CategoryEntity oldCategory){
        oldCategory.setCode(categoryDTO.getCode());
        oldCategory.setName(categoryDTO.getName());
        return oldCategory;
    }
}
