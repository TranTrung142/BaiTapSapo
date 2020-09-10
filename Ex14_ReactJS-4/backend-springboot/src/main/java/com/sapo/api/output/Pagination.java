package com.sapo.api.output;

import com.sapo.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
    private int page;
    private int totalPage;
    private List<CategoryEntity> listCategory = new ArrayList<CategoryEntity>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<CategoryEntity> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<CategoryEntity> listCategory) {
        this.listCategory = listCategory;
    }
}
