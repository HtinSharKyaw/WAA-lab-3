package com.example.lab3.unidirectional.service;

import com.example.lab3.unidirectional.entity.Address;

import java.util.Optional;


public interface AddressService {
    void save(Address address);

    Address getById(int id);

    void delete(int id);

}
