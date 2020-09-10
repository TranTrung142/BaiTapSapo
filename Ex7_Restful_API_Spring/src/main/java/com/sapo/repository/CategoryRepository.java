package com.sapo.repository;

import com.sapo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findOneByCode(String code); //tim simple code
    CategoryEntity findOneById(Long id);
    List<CategoryEntity> findByCodeContaining(String code);
}
