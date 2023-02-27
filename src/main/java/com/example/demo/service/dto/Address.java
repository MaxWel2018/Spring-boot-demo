package com.example.demo.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private  String id;
    private  String streetName;
    private  String buildNumber;
}
