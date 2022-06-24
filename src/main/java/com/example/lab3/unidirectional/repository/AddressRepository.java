package com.example.lab3.unidirectional.repository;

import com.example.lab3.unidirectional.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {
}
