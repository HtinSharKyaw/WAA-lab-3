package com.example.lab3.unidirectional.service.impl;

import com.example.lab3.unidirectional.dto.AddressDTO;
import com.example.lab3.unidirectional.entity.Address;
import com.example.lab3.unidirectional.repository.AddressRepository;
import com.example.lab3.unidirectional.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    ModelMapper modelMapper;

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address getById(int id) {
       return (addressRepository.findById(id).isPresent()) ? addressRepository.findById(id).get() : null;
    }

    @Override
    public void delete(int id) {
        Address address = getById(id);
        if(null != address){
            addressRepository.delete(address);
        }
    }

    //use model mapper here
    public AddressDTO toDTO(Address address){
        return modelMapper.map(address,AddressDTO.class);
    }

    public Address toEntity(AddressDTO addressDTO){
        return modelMapper.map(addressDTO,Address.class);
    }
}
