package com.example.lab3.bidirectional.repository;

import com.example.lab3.bidirectional.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
