package com.example.demo.repository.entity;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class AddressEntity {
    private String id;
    private String streetName;
    private String buildNumber;

}
