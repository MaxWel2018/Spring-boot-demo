package com.example.demo.utils;

import com.example.demo.repository.entity.AddressEntity;
import com.example.demo.repository.entity.UserEntity;
import com.github.javafaker.Faker;

import java.util.List;
import java.util.stream.IntStream;

public class DataProvider {

    public static UserEntity user() {
        return generateRandomUser();
    }

    public static List<UserEntity> users(Integer numbers) {
        return IntStream.range(0, numbers).boxed().map(num -> generateRandomUser()).toList();
    }

    private static UserEntity generateRandomUser() {
        Faker faker = new Faker();

        return UserEntity.builder()
                .id(faker.idNumber().valid())
                .name(faker.name().firstName())
                .lastname(faker.name().lastName())
                .addressEntity(getAddressEntity(faker))
                .build();
    }

    private static AddressEntity getAddressEntity(Faker faker) {
        return AddressEntity.builder()
                .id(faker.idNumber().valid())
                .streetName(faker.address().streetAddress())
                .buildNumber(faker.address().buildingNumber())
                .build();
    }
}
