package com.sapo.service;

import com.sapo.dto.CategoryDTO;
import com.sapo.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
//    void deleteCategory(Long id);
//    CategoryDTO save(CategoryDTO model);
//    List<CategoryDTO> getCategory(String code);
    List<CategoryEntity> getCategory();
    CategoryEntity getProductByCategory(Long id);
}
