package com.sapo.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass       //de cac lop ke thua no co cac thuoc tinh cua BaseEntity
@EntityListeners(AuditingEntityListener.class)  //set date and user
public abstract class BaseEntity {
    @Id     //@Id = not null + primery key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //giup id tu tang, auto_increment
    private Long id;
    @Column (nullable = false)
    @CreatedDate
    private Date createdDate;
    @Column (nullable = false)
    @LastModifiedDate
    private Date modifiedDate;

    public Long getId() {
        return id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
