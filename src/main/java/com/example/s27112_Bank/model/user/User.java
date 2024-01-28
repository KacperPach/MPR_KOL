package com.example.s27112_Bank.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String pesel;

}
