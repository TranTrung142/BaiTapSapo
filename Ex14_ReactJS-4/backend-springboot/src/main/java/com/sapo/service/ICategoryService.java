package com.sapo.service;

import com.sapo.dto.CategoryDTO;
import com.sapo.entity.CategoryEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<CategoryEntity> getCategory();
    CategoryEntity getProductByCategory(Long id);
    List<CategoryEntity> pagination(Pageable pageable);
    int totalCategory();
    void saveCategory(CategoryEntity categoryEntity);
    void updateCategory(CategoryEntity categoryEntity, Long id);
    void deleteCategory(Long id);
}
