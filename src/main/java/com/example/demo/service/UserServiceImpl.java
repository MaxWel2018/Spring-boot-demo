package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.UserEntity;
import com.example.demo.service.dto.User;
import com.example.demo.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
