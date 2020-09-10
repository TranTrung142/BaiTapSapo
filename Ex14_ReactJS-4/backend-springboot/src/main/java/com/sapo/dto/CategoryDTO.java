package com.sapo.dto;

import com.sapo.entity.CategoryEntity;
import com.sapo.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO extends AbstractDTO<ProductEntity> {
    private String name;
//    private String code;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
