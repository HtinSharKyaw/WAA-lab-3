package com.example.lab3.unidirectional.service.impl;

import com.example.lab3.unidirectional.dto.UserDTO;
import com.example.lab3.unidirectional.entity.User;
import com.example.lab3.unidirectional.repository.UserRepository;
import com.example.lab3.unidirectional.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        User user = findById(id);
        if (null != user) {
            userRepository.delete(user);
        }
    }

    @Override
    public User findById(int id) {
        return (userRepository.findById(id).isPresent()) ? userRepository.findById(id).get() : null;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
    //use model mapper here

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}
