package com.example.demo.service.mapper;

import com.example.demo.repository.entity.UserEntity;
import com.example.demo.service.dto.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "addressEntity", target = "address")
    User mapEntityToDto(UserEntity userEntity);

    @Mapping(source = "address", target = "addressEntity")
    UserEntity mapDtoToEntity(User user);

}
