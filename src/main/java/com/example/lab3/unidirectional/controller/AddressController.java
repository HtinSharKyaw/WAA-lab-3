package com.example.lab3.unidirectional.controller;

import com.example.lab3.unidirectional.entity.Address;
import com.example.lab3.unidirectional.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public void createAddress(@RequestBody Address address){
        addressService.save(address);
    }



}
