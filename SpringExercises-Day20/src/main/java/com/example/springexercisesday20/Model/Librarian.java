package com.example.springexercisesday20.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Librarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "username cannot be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "password should be strong")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message ="email cannot be empty")
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;
}
