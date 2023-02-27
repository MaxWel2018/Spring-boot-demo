package com.example.demo.service.dto;

import com.example.demo.repository.entity.AddressEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String id;
    private String name;
    private String lastname;
    private Address address;
}
