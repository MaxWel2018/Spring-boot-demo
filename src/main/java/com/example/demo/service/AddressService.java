package com.example.demo.service;

import com.example.demo.service.dto.Address;

import java.util.List;

public interface AddressService {
    Address findById(String id);
    Address save(Address address);
    Address update(String id, Address address);
    List<Address> findAll();
    void deleteById(String id);
    List<Address> findAllByStreetName(String street);
}
