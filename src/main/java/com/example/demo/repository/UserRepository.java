package com.example.demo.repository;

import com.example.demo.repository.entity.UserEntity;

import java.util.List;

public interface UserRepository{
    UserEntity findById(String id);
    List<UserEntity> save(UserEntity userEntity);

    UserEntity updateUser(String id, UserEntity userEntity);

    List<UserEntity> findAll();

    void deleteById(String id);

    UserEntity findByName(String name);
}
