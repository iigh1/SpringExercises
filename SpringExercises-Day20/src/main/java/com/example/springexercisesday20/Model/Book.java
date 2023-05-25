package com.example.springexercisesday20.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "title cannot be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String title;

    @NotEmpty(message = "author cannot be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String author;

    @NotEmpty(message = "category cannot be empty")
    @Column(columnDefinition = "varchar(20) not null check(category='Academic' or category='Mystery' or category='Novel' )")
    private String category;

    @NotNull(message = "ISBN cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer ISBN;

    @NotNull(message = "numberOfPages cannot be empty")
    @Size(min = 50, max = 200, message = "numberOfPages should be between 50 and 200")
    @Column(columnDefinition = "varchar(200) not null")
    private Integer numberOfPages;
}
