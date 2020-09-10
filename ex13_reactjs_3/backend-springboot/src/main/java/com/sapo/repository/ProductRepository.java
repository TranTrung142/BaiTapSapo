package com.sapo.repository;

import com.sapo.entity.CategoryEntity;
import com.sapo.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByCategory(CategoryEntity entity);
}
