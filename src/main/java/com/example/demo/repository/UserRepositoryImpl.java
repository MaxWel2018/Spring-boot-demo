package com.example.demo.repository;

import com.example.demo.repository.entity.UserEntity;
import com.example.demo.utils.DataProvider;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserEntity findById(String id) {
        return DataProvider.user();
    }
}
