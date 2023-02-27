package com.example.demo.repository.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressEntity {
    private final String id;
    private final String streetName;
    private final String buildNumber;

}
