package com.example.lab3.bidirectional.repository;

import com.example.lab3.bidirectional.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {
}
