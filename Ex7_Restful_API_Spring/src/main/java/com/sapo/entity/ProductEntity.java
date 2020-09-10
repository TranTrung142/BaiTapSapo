package com.sapo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String productImagePath;
    @Column
    private int price;
    @Column
    private int countProduct;
    @Column
    private int countSell;
    @Column
    private String description;

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

    public int getPrice() {
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
