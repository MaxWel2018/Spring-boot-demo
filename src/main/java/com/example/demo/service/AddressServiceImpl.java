package com.example.demo.service;

import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.entity.AddressEntity;
import com.example.demo.service.dto.Address;
import com.example.demo.service.mapper.AddressMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }


    @Override
    public Address findById(String id) {
        return addressRepository.findById(id)
                .map(addressMapper::mapEntityToDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Address save(Address address) {
        AddressEntity addressEntity = addressMapper.mapDtoToEntity(address);
        AddressEntity savedAddress = addressRepository.save(addressEntity);
        return addressMapper.mapEntityToDto(savedAddress);
    }

    @Override
    public Address update(String id, Address address) {
        AddressEntity addressEntity = addressMapper.mapDtoToEntity(address);
        if (!addressRepository.existsById(id)) {
            throw new EntityNotFoundException("Address with id not found");
        }
        AddressEntity updatedAddress = addressRepository.save(addressEntity);
        return addressMapper.mapEntityToDto(updatedAddress);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll().stream()
                .map(addressMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAllByStreetName(String street) {
        return addressRepository.findAllByStreetName(street).stream()
                .map(addressMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

}
