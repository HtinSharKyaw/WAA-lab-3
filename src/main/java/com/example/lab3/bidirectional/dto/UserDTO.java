package com.example.lab3.bidirectional.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
