package com.sapo.service.impl;

import com.sapo.entity.UserEntity;
import com.sapo.repository.UserRepository;
import com.sapo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity login(UserEntity user) {
        UserEntity userEntity = userRepository.findOneByUserName(user.getUserName());
        if(userEntity != null ){
            if(user.getPassword().equals(userEntity.getPassword())){
                userEntity.setPassword(null);
                return userEntity;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }
}
