package com.sapo.dto;

import com.sapo.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO extends AbstractDTO<NewDTO> {
    private String name;
    private String code;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
