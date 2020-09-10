package com.sapo.api;

import com.sapo.entity.UserEntity;
import com.sapo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPI {
    @Autowired
    IUserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody UserEntity user){
        try{
            return ResponseEntity.ok().body(userService.login(user));
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UserEntity user){
        try{
            userService.saveUser(user);
            return ResponseEntity.ok().body("save new user success");
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
