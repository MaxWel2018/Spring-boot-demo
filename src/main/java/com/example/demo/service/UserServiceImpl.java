package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.UserEntity;
import com.example.demo.service.dto.User;
import com.example.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    //    private UserRepository userRepository = ApplicationContext.getBean("userRepository");
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User findById(String id) {
        UserEntity user = userRepository.findById(id);
        return userMapper.mapEntityToDto(user);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.mapDtoToEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.mapEntityToDto(savedUserEntity);
    }

    @Override
    public User updateUser(String id, User user) {
        UserEntity userEntity = userMapper.mapDtoToEntity(user);
        UserEntity updatedUser = userRepository.updateUser(id, userEntity);
        return userMapper.mapEntityToDto(updatedUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::mapEntityToDto)
                .toList();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByName(String name) {
        UserEntity userEntity = userRepository.findByName(name);
        return userMapper.mapEntityToDto(userEntity);
    }
}