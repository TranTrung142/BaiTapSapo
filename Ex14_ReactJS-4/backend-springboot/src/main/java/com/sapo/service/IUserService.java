package com.sapo.service;

import com.sapo.entity.UserEntity;

public interface IUserService {
    UserEntity login(UserEntity user);
    void saveUser(UserEntity user);
}
