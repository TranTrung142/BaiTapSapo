package com.sapo.service.impl;

import com.sapo.entity.CategoryEntity;
import com.sapo.entity.ProductEntity;
import com.sapo.repository.CategoryRepository;
import com.sapo.repository.ProductRepository;
import com.sapo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<CategoryEntity> getCategory() {
        List<CategoryEntity> categoryEntities = new ArrayList<CategoryEntity>();
        categoryEntities = categoryRepository.findAll();
        for(CategoryEntity entity : categoryEntities){
            entity.setProducts(null);
        }
        return categoryEntities;
    }

    @Override
    public CategoryEntity getProductByCategory(Long id) {
        CategoryEntity categoryEntity;
        categoryEntity = categoryRepository.findOne(id);
        List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
        productEntities = productRepository.findByCategory(categoryEntity);
        for(ProductEntity entity : productEntities){
            entity.setCategory(null);
        }
        categoryEntity.setProducts(productEntities);
        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> pagination(Pageable pageable) {
        List<CategoryEntity> categoryEntities = new ArrayList<CategoryEntity>();
        categoryEntities = categoryRepository.findAll(pageable).getContent();
        for(CategoryEntity entity : categoryEntities){
            entity.setProducts(null);
        }
        return categoryEntities;
    }

    @Override
    public int totalCategory() {
        return (int) categoryRepository.count();
    }

    @Override
    public void saveCategory(CategoryEntity categoryEntity) {
            categoryRepository.save(categoryEntity);
    }

    @Override
    public void updateCategory(CategoryEntity categoryEntity, Long id) {
        CategoryEntity entity = categoryRepository.findOneById(id);
        entity.setDescription(categoryEntity.getDescription());
        entity.setName(categoryEntity.getName());
        categoryRepository.save(entity);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.delete(id);
    }
}
