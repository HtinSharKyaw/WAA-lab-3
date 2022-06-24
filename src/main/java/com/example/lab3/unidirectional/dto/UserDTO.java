package com.example.lab3.unidirectional.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
