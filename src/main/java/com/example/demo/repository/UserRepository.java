package com.example.demo.repository;

import com.example.demo.repository.entity.UserEntity;

public interface UserRepository{
    UserEntity findById(String id);

}
