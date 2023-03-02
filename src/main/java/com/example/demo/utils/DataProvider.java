package com.example.demo.utils;

import com.example.demo.repository.entity.AddressEntity;
import com.example.demo.repository.entity.UserEntity;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DataProvider {
    private static final List<UserEntity> userEntityList = new ArrayList<>();

    public static final String USER_WITH_NAME_IS_NOT_EXIST = "User with name is not exist";

    public static List<UserEntity> saveUser(UserEntity userEntity) {
        userEntityList.add(userEntity);
        return userEntityList;
    }

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

    public static UserEntity updateUser(String id, UserEntity userEntity) {
        int intId = Integer.parseInt(id);
        userEntityList.set(intId, userEntity);
        return userEntity;
    }

    public static List<UserEntity> findAll() {
        return userEntityList;
    }

    public static void deleteById(String id) {
        try {
            int intId = Integer.parseInt(id);
            userEntityList.remove(intId);
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Not valid index value");
        }
    }

    public static UserEntity findByName(String name) {
        return userEntityList.stream()
                .filter(t -> t.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(USER_WITH_NAME_IS_NOT_EXIST));
    }
}
