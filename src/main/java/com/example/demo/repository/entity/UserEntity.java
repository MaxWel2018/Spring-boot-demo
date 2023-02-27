package com.example.demo.repository.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class UserEntity {
    private String id;
    private String name;
    private String lastname;
    private AddressEntity addressEntity;

}

