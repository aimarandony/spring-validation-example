package com.example.validation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Description empty.")
    @NotNull(message = "Description null.")
    private String description;

    @Max(value = 20, message = "Stock max values is 20.")
    @NotNull(message = "Stock null.")
    private Integer stock;

    @Email(message = "Email format invalid.")
    @NotEmpty(message = "Email empty.")
    @NotNull(message = "Email null.")
    private String email;

    @NotNull(message = "Price null.")
    private Double price;

    @NotNull(message = "Status null.")
    private Boolean status;
}
