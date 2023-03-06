package com.example.demo.controller;

import com.example.demo.service.AddressService;
import com.example.demo.service.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/find/{id}")
    public Address findById(@PathVariable String id) {
        return addressService.findById(id);
    }

    @GetMapping("/find/all")
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable String id, Address address) {
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable String id) {
        addressService.deleteById(id);
    }

    @GetMapping("/street/{streetName}")
    public List<Address> findAllByStreetName(@PathVariable String streetName) {
        return addressService.findAllByStreetName(streetName);
    }
}
