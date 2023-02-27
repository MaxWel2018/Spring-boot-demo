package com.example.demo.service.mapper;


import com.example.demo.repository.entity.AddressEntity;
import com.example.demo.service.dto.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address mapEntityToDto(AddressEntity addressEntity);

    AddressEntity mapDtoToEntity(Address address);
}
