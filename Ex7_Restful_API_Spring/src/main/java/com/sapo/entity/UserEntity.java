package com.sapo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String fullName;
    @Column
    private Integer status;

    @ManyToMany
    @JoinTable(
            name = "user_role",     //ten bang trung gian
            joinColumns = @JoinColumn(name = "user_id"),    //id cua lop user
            inverseJoinColumns = @JoinColumn(name = "role_id")      //id cua lop role
    )
    private List<RoleEntity> roles = new ArrayList<RoleEntity>();    //

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
