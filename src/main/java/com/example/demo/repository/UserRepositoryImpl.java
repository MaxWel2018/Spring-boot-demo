package com.example.demo.repository;

import com.example.demo.repository.entity.UserEntity;
import com.example.demo.utils.DataProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public UserEntity findById(String id) {
        return DataProvider.user();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return DataProvider.saveUser(userEntity);
    }

    @Override
    public UserEntity updateUser(String id, UserEntity userEntity) {
        return DataProvider.updateUser(id,userEntity);
    }

    @Override
    public List<UserEntity> findAll() {
        return DataProvider.findAll();
    }

    @Override
    public void deleteById(String id) {
        DataProvider.deleteById(id);
    }

    @Override
    public UserEntity findByName(String name) {
        return DataProvider.findByName(name);
    }
}
