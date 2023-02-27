package com.example.demo.repository.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {
    private final String name;
    private final String lastname;
    private final AddressEntity addressEntity;


}
