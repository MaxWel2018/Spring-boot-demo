package com.example.demo.repository;

import com.example.demo.repository.entity.AddressEntity;
import com.example.demo.service.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, String> {
    List<AddressEntity> findAllByStreetName(String streetName);
}
