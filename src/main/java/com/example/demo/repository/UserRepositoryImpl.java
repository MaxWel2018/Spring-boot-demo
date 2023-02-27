package com.example.demo.repository;

import com.example.demo.repository.entity.UserEntity;
import com.example.demo.utils.DataProvider;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserEntity findById(String id) {
        return DataProvider.user();
    }
}
