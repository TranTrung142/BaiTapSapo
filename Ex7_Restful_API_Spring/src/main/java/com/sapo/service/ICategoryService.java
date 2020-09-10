package com.sapo.service;

import com.sapo.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    void deleteCategory(Long id);
    CategoryDTO save(CategoryDTO model);
    List<CategoryDTO> getCategory(String code);
    List<CategoryDTO> getCategory();
    CategoryDTO getNewByCategory(Long id);
}
