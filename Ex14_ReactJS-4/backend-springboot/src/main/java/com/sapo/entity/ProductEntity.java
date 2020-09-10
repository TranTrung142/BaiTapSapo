package com.sapo.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Column (length = 255, nullable = false)
    private String name;
    @Column (length = 255, nullable = false)
    private String productImagePath;
    @Column (length = 255, nullable = false)
    private double price;
    @Column (length = 255, nullable = false)
    private int countProduct;
    @Column (length = 255, nullable = false)
    private int countSell;
    @Column (length = 1000, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public int getCountSell() {
        return countSell;
    }

    public void setCountSell(int countSell) {
        this.countSell = countSell;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
