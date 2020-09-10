package com.sapo.repository;

import com.sapo.entity.CategoryEntity;
import com.sapo.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
    //NewEntity findByTitle(String title);
    //NewEntity findOneByTitle(String title);
    List<NewEntity> findByTitleContaining(String title);
    List<NewEntity> findByCategory(CategoryEntity categoryEntity);
}
